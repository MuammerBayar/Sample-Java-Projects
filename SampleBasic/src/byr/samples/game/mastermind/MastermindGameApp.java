/*----------------------------------------------------------------------------------------------------------------------
    not:
    aynı rakamlardan oluşan sayı girildiğinde istenilen tepkiyi vermiyor düzeltilecek..
----------------------------------------------------------------------------------------------------------------------*/

package byr.samples.game.mastermind;

import static byr.util.number.NumberUtil.*;

import java.util.Random;
import java.util.Scanner;

public class MastermindGameApp {
    public static int enteredNumber;
    public static int keptNumber;
    public static int minusNum, plusNum;
    public static int getNumber(Random r) // [1000,9999]
    {
        for (;;) {
            int n =r.nextInt(9000) + 1000;

            if (isDigitsDifferent(n))
                return n;
        }
    }
    public static void setStatus()
    {
        minusNum = 0;
        plusNum = 0;

        int [] aKept= getDigits(keptNumber);
        int [] aEntered = getDigits(enteredNumber);

        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 4; ++k)
                if(aKept[i] == aEntered[k])
                    if (i == k)
                        ++plusNum;
                    else
                        ++minusNum;
        }
    }

    public static void printStatusMessage()
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

    public static void printstartMessage()
    {
        System.out.println("---------------------------------");
        System.out.printf("Belirlenen sayı:%d%n",keptNumber);
        System.out.println("Oyun başlamıştır çıkış için [0] giriniz.");
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
