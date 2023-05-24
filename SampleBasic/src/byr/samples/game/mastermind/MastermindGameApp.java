/*----------------------------------------------------------------------------------------------------------------------
    MastermindGameApp Sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.game.mastermind;

import static byr.util.number.NumberUtil.*;

import java.util.Random;
import java.util.Scanner;

public final class MastermindGameApp {
    private static int enteredNumber;
    private static int keptNumber;
    private static int minusNum, plusNum;
    private static int getNumber(Random r) // [1000,9999]
    {
        for (;;) {
            int n =r.nextInt(9000) + 1000;

            if (isDigitsDifferent(n))
                return n;
        }
    }

    private static void setStatus()
    {
        minusNum = 0;
        plusNum = 0;
        boolean [] nums = new boolean[10];

        int [] aKept= getDigits(keptNumber);
        int [] aEntered = getDigits(enteredNumber);

        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 4; ++k)
                if(aKept[i] == aEntered[k] && !nums[aKept[i]])
                    if (i == k) {
                        ++plusNum;
                        nums[aKept[i]] = true;
                    }
                    else {
                        ++minusNum;
                        nums[aKept[i]] = true;
                    }
        }
    }

    private static void printStatusMessage()
    {
        setStatus();

        System.out.printf("Belirlenen sayı:%d%n",keptNumber);
        System.out.printf("Tahmin edilen sayı:%d%n",enteredNumber);
        System.out.print("Status:");

        if (plusNum > 0)
            System.out.printf("+%d",plusNum);
        if (minusNum > 0)
            System.out.printf("-%d",minusNum);

        System.out.println();
    }

    private static void printstartMessage()
    {
        System.out.println("---------------------------------");
        System.out.printf("Belirlenen sayı:%d%n",keptNumber);
        System.out.println("Oyun başlamıştır çıkış için [0] giriniz.");
    }
    private MastermindGameApp()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        for (;;) {
            keptNumber = getNumber(r);

            printstartMessage();

            int i;
            for (i = 0; i < 10; ++i) {
                System.out.printf("%d. tahmininizi giriniz: ", i + 1);
                enteredNumber = Integer.parseInt(kb.nextLine());

                if (enteredNumber == 0)
                    return;

                System.out.println("---------------------------------");
                printStatusMessage();
                System.out.println("---------------------------------");

                if(keptNumber == enteredNumber)
                    break;
            }

            if (i == 10)
                System.out.println("Deneme hakkınız bitti. Oyunu kaybettiniz.");
            else
                System.out.printf("Tebrikler %d. denemede Kazandınız.%n",i + 1);

        }
    }
}
