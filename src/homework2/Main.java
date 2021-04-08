package homework2;
//
//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
// MyArrayDataException, и вывести результат расчета.

import homework2.myexceptions.MyArrayDataException;
import homework2.myexceptions.MyArraySizeException;

public class Main {
    private static final int EXPECTED_SIZE = 4;

    public static void main(String[] args) {
        String[][] strMatrixNormal = {{"1", "2", "3", "4"},
                {"5", "6", "7", "2"},
                {"9", "0", "1", "0"},
                {"5", "4", "0", "1"}
        };

        tryCalculateSum(strMatrixNormal);

        String[][] strMatrixWrongRows = {{"1", "2", "3"},
                {"5", "6", "7", "2", "10"},
                {"9", "0", "1", "0"},
                {"5", "4", "0", "1"},
                {"3"}
        };

        tryCalculateSum(strMatrixWrongRows);

        String[][] strMatrixWrongCols = {
                {"1", "2", "3"},
                {"5", "6", "7", "2", "10"},
                {"9", "0", "1", "0"},
                {"5", "4", "0", "1"}
        };

        tryCalculateSum(strMatrixWrongCols);

        String[][] strMatrixWrongElement = {
                {"1", "2", "3", "6"},
                {"5", "6", "7", "2"},
                {"9", "0", "fgh", "0"},
                {"5", "4", "0", "1"}
        };

        tryCalculateSum(strMatrixWrongElement);

    }

    private static void tryCalculateSum(String[][] strMatrixNormal) {
        try {
            System.out.println(calculateSum(strMatrixNormal));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getSum() + " это сумма не всех элементов, т.к. были проблемы конвертации строки в число.");
        }
    }

    static int calculateSum(String[][] strMatrix) throws MyArraySizeException, NumberFormatException {
        checkMatrixSize(strMatrix);

        int sum = getSum(strMatrix);

        return sum;
    }

    private static int getSum(String[][] strMatrix) {
        boolean wasNumberFormatException = false;
        int sum = 0;
        for (int i = 0; i < EXPECTED_SIZE; i++) {
            for (int j = 0; j < EXPECTED_SIZE; j++) {

                try {
                    sum += Integer.parseInt(strMatrix[i][j]);
                } catch (NumberFormatException e) {
                    System.out.printf("Элемент массива [%d][%d] невозможно преобразовать в целове число. Этот элемент не будет учтен при подсчете суммы.\n", i, j);
                    wasNumberFormatException = true;
                }
            }
        }

        if (wasNumberFormatException) {
            throw new MyArrayDataException(sum);
        }

        return sum;
    }

    private static void checkMatrixSize(String[][] strMatrix) {
        if (strMatrix.length != EXPECTED_SIZE) {
            throw new MyArraySizeException(String.format("Количество строк в переданной матрице = %d " +
                    "не соответствует ожидаемой EXPECTED_SIZE = %d. Расчета суммы не будет."
                    , strMatrix.length, EXPECTED_SIZE));
        }

        for (int i = 0; i < strMatrix.length; i++) {
            if (strMatrix[i].length != EXPECTED_SIZE) {
                throw new MyArraySizeException(String.format("В переданной матрице количество элементов в %d строке = %d " +
                                "не соответствует ожидаемой EXPECTED_SIZE = %d. Расчета суммы не будет."
                        , i, strMatrix[i].length, EXPECTED_SIZE));
            }
        }
    }
}
