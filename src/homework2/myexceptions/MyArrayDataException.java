package homework2.myexceptions;

public class MyArrayDataException extends ClassCastException{
    int sum;

    public int getSum() {
        return sum;
    }

    public MyArrayDataException(int sum) {
        this.sum = sum;
    }
}
