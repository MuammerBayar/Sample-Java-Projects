/*----------------------------------------------------------------------------------------------------------------------
    NumericLottery Sınıfı
    Son güncelleme:30.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.numericlottery;

import java.util.Random;

public class NumericLottery {
    public static boolean [] numberFlag;

    public static void fillRandomNumberFlag(Random r)
    {
        numberFlag = new boolean[50];

        int count = 0;
        while (count != 6) {
            int index = r.nextInt(49) + 1;

            if (!numberFlag[index]) {
                numberFlag[index] = true;
                ++count;
            }
        }
    }
    public static int [] getCoupon(Random r)
    {
        int [] a = new int[6];
        fillRandomNumberFlag(r);

        int index = 1;
        for (int i = 0; i < 6; ++i)
             for (;;)
                if (numberFlag[index++]) {
                    a[i] = index;
                    break;
                }


        return a;
    }
}




