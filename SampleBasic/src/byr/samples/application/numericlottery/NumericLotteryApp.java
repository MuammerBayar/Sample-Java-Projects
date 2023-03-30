/*----------------------------------------------------------------------------------------------------------------------
    NumericLotteryApp Sınıfı
    Son güncelleme:30.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.numericlottery;

import byr.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class NumericLotteryApp {

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        for (;;) {
            System.out.print("kupon sayısını giriniz: ");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            System.out.println("-------------------------------");

            for (int i = 0; i < n; ++i)
                ArrayUtil.display(2,NumericLottery.getCoupon(r));

            System.out.println("-------------------------------");
        }

        System.out.println("Tekrar yapıyor musun?");
    }
}
