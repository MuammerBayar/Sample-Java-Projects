/*----------------------------------------------------------------------------------------------------------------------
    izlenecek:17.video
----------------------------------------------------------------------------------------------------------------------*/
package samples;

public class Main {
    public static void main(String [] args)
    {
        GcdTest.run();
    }
}

class GcdTest {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Birinci sayıyı giriniz:");
            int a = Integer.parseInt(kb.nextLine());

            System.out.print("İkinci sayıyı giriniz:");
            int b = Integer.parseInt(kb.nextLine());

            int result = NumberUtil.gcd(a, b);

            System.out.printf("obeb(%d, %d) = %d%n", a, b, result);
            if (result == 1)
                break;
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class NumberUtil {
    public static int gcd(int a, int b)
    {
        int devider = Math.min(a,b);

        if (Math.max(a,b) % devider == 0)
            return devider;
        else
            devider /= 2;

        for (;;) {

            if (a % devider == 0 && b % devider == 0)
                return devider;

            --devider;
        }
    }
}