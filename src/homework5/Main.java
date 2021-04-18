package homework5;

//1. Необходимо написать два метода, которые делают следующее:
//        1) Создают одномерный длинный массив, например:
//
//static final int size = 10000000;
//static final int h = size / 2;
//        float[] arr = new float[size];
//
//        2) Заполняют этот массив единицами;
//        3) Засекают время выполнения: long a = System.currentTimeMillis();
//        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        5) Проверяется время окончания метода System.currentTimeMillis();
//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//
//        Отличие первого метода от второго:
//        Первый просто бежит по массиву и вычисляет значения.
//        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//
//        Пример деления одного массива на два:
//
//        System.arraycopy(arr, 0, a1, 0, h);
//        System.arraycopy(arr, h, a2, 0, h);
//
//        Пример обратной склейки:
//
//        System.arraycopy(a1, 0, arr, 0, h);
//        System.arraycopy(a2, 0, arr, h, h);
//
//        Примечание:
//        System.arraycopy() – копирует данные из одного массива в другой:
//        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//        По замерам времени:
//        Для первого метода надо считать время только на цикл расчета:
//
//        for (int i = 0; i < size; i++) {
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//
//        Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        function1();
        System.out.println();
        function2();
    }

    static void function1() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = f(arr[i], i);
        }

        long finish = System.currentTimeMillis();

        System.out.println("Время работы первого метода, мсек: " + (finish - start));
    }

    private static float f(float ai, int i) {
        return (float) (ai * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    static void function2() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long startSplit = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long finishSplit = System.currentTimeMillis();


        long startCalc = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = f(a1[i], i);
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = f(a2[i], i);
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finishCalc = System.currentTimeMillis();

        long startConcat = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long finishConcat = System.currentTimeMillis();

        long timeSplit = finishSplit - startSplit;
        long timeCalc = finishCalc - startCalc;
        long timeConcat = finishConcat - startConcat;
        long total = timeCalc + timeConcat + timeSplit;

        System.out.println("Время работы второго метода:");
        System.out.println("    время разбивки на два подмассива, мсек: " + timeSplit);
        System.out.println("    время расчета в двух потоках, мсек: " + timeCalc);
        System.out.println("    время слияния два массива в один, мсек: " + timeConcat);
        System.out.println("    время общее работы метода, мсек: " + total);
    }
}
