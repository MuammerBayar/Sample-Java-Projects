/*----------------------------------------------------------------------------------------------------------------------
    izlenecek (oop):32.video
    izlenecek (app): -
----------------------------------------------------------------------------------------------------------------------*/
package byr.main;

import java.util.Scanner;

import static byr.util.array.ArrayUtil.*;

public class Main {
    public static void main(String [] args)
    {
        SecondMaxTest.run();
    }
}

class SecondMaxTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Eleman sayısı giriniz: ");
            int n = Integer.parseInt(kb.nextLine());

            if (n == 0)
                break;

            int [] a = getRandomArray(n,1,100);
            int secMax = ArrayUtil.secondMax(a);

            bubbleSort(a);
            display(2,a);
            System.out.printf("Second max: %d%n",secMax);
        }
    }
}

class ArrayUtil {
    public static int secondMax(int [] a)
    {
        int max = max(a);
        int secMax = a[0];

        if (max == secMax)
            secMax = a[1];

        for (int i = 0; i < a.length; ++i) {
            if (a[i] != max && secMax < a[i])
                secMax = a[i];
        }

        return secMax;
    }
}

