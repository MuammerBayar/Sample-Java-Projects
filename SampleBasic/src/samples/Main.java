/*----------------------------------------------------------------------------------------------------------------------
    izlenecek (oop):18.video
    izlenecek (app): -
----------------------------------------------------------------------------------------------------------------------*/
package samples;

public class Main {
    public static void main(String [] args)
    {
        SumFactorsTest.run();
    }
}

class SumFactorsTest {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("bir sayı giriniz: ");
            int val = Integer.parseInt(kb.nextLine());

            if (val == 0)
                break;
            System.out.printf("%d sayısının  Çarpanları toplamı: %d%n", val, NumberUtil.sumFactors(val));
        }
    }
}

class NumberUtil {
    public static int sumFactors(int val)
    {
        int sum = 1;

        for (int i = 2; i <= val / 2; ++i)
            if (val % i == 0)
                sum += i;

        return sum;
    }
}