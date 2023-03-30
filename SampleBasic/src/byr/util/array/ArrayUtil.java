/*----------------------------------------------------------------------------------------------------------------------
    ArrayUtil Sınıfı
    last update:28.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.util.array;

import java.util.Random;

public class ArrayUtil {
    public static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] > a[k + 1])
                    swap(a, k, k + 1);
    }

    public static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    public static void selectionSortAscending(int [] a)
    {
        for (int i = 0; i < a.length; ++i) {
            int minVal = a[i];

            for (int k = 1 + i; k < a.length; ++k)
                if (minVal > a[k]) {
                    minVal = a[k];
                    swap(a, i, k);
                }
        }
    }

    public static void selectionSortDescending(int [] a)
    {

        for (int i = 0; i < a.length; ++i) {
            int maxVal = a[i];

            for (int k = 1 + i; k < a.length; ++k)
                if (maxVal < a[k]) {
                    maxVal = a[k];
                    swap(a, i, k);
                }
        }
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a, boolean desc)
    {
        if (desc)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void display (int [] a)
    {
        display(1,a);
    }

    public static void display (int n, int [] a)
    {
        String fmt = String.format("%%0%dd ",n);

        for (int i = 0; i < a.length; ++i)
            System.out.printf(fmt,a[i]);

        System.out.println();
    }

    public static void fillRandomArray(Random r, int [] a, int min, int max) //[min,max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;
    }

    public static void fillRandomArray(int [] a, int min, int max) //[min,max)
    {
        fillRandomArray(new Random(),a,min,max);
    }

    public static int [] getHistogramData(int [] a, int n) // [0,n]
    {
        int [] count = new int[n + 1];

        for (int i = 0; i < a.length; ++i)
            ++count[a[i]];

        return count;
    }
    public static int [] getRandomArray(Random r, int n, int min, int max) //[min,max)
    {
           int [] a = new int[n];

           fillRandomArray(r,a,min,max);

           return a;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min,max)
    {
        int [] a = new int[n];

        fillRandomArray(a,min,max);

        return a;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex < a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, partitionIndex++, i);

        return partitionIndex;
    }
    public static void reverse(int [] a)
    {
        int length = a.length / 2;

        for (int i = 0; i < length; ++i)
            swap(a,i,a.length - 1 - i);
    }

    public static void selectionSort(int [] a)
    {
        selectionSortAscending(a);
    }

    public static void selectionSort(int [] a, boolean desc)
    {
        if (desc)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static int sum(int [] a)
    {
        int sum = 0;
        for (int i = 0; i < a.length;++i)
            sum += a[i];

        return sum;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
