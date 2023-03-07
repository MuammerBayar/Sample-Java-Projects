/*----------------------------------------------------------------------------------------------------------------------
    izlenecek (oop):17.video
    izlenecek (app): -
----------------------------------------------------------------------------------------------------------------------*/
package samples;

public class Main {
    public static void main(String [] args)
    {
        PrintPrimeFactorApp.run();
    }
}
class PrintPrimeFactorApp{
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("bir değer giriniz:");
            int val = Integer.parseInt(kb.nextLine());

            if (val == 0)
                break;

            if (val <= 2 || val % 2 != 0) {
                System.out.println("Geçersiz değer!");
                continue;
            }

            printPrimeFactor(Math.abs(val));
        }
    }

    public static void printPrimeFactor (int val)
    {

    }

    public static boolean isPrime(long val)
    {
        if (val <= 1)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        for (long i = 11; i * i <= val; i += 2)
            if (val % i == 0)
                return false;

        return true;
    }

}

