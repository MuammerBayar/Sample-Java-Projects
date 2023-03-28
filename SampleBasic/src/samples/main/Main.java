/*----------------------------------------------------------------------------------------------------------------------
    izlenecek (oop):31.video
    izlenecek (app): -
----------------------------------------------------------------------------------------------------------------------*/
package samples.main;

import java.util.Random;
import java.util.Scanner;

import static util.array.ArrayUtil.*;

public class Main {
    public static void main(String [] args)
    {
        SelectionSortTest.run();
    }
}

class SelectionSortTest {
    public static void run()
    {
        Random r = new Random();
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Dizinin eleman sayısını giriniz:");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            int [] a = getRandomArray(r, n, 0, 99);

            display(2, a);

            boolean desc = r.nextBoolean();

            selectionSort(a, desc);

            System.out.printf("%s sıralanmış dizi:%n", desc ? "Büyükten küçüğe" : "Küçükten büyüğe");
            display(2, a);
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
