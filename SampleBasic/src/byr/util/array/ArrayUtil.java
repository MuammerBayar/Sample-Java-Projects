/*----------------------------------------------------------------------------------------------------------------------
    ArrayUtil Sınıfı
    last update:08.04.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.util.array;

import java.util.Random;

import static java.lang.Math.sqrt;

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

    public static double average(int [] a)
    {
        return (double)sum(a) / a.length;
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

    public static void drawHistogram(int [] data,int n, char ch)
    {
        int maxVal = max(data);

        for (int i = 0; i < data.length; ++i) {
            int x = (int)Math.ceil((double)n * data[i] / maxVal);
            System.out.println((ch + "").repeat(x));
        }
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

    public static int firstRepeated(int [] a)
    {
        int index = a.length - 1;

        for (int i = 0; i < a.length; ++i)
            for (int k = i + 1; k < a.length; ++k)
                if (a[i] == a[k])
                    if (k < index)
                        index = k;


        return a[index];
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


    public static int max(int [] a)
    {
        int maxVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (maxVal < a[i])
                maxVal = a[i];

        return maxVal;
    }
    public static int min(int [] a)
    {
        int minVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (minVal > a[i])
                minVal = a[i];

        return minVal;
    }
    public static int mod(int [] a)
    {
        int [] counter = new int[max(a) + 1];
        int index = 0;

        for (int i = 0; i < a.length; ++i) {
            ++counter[a[i]];
            if (counter[index] < counter[a[i]])
                index = a[i];
        }

        return index;
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

    public static double standardDeviation(int [] a)
    {
        double avg = average(a);

        double sum = 0;

        for (int i = 0; i < a.length; ++i)
            sum += Math.pow(a[i] - avg, 2);

        return sqrt(sum / a.length - 1);
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
    public static void swap(char [] a, int i, int k)
    {
        char temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
