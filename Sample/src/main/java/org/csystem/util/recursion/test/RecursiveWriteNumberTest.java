/*----------------------------------------------------------------------------------------------------------------------
    Yalnızca bir tane karakteri ekrana yazan metot ve dizi kullanarak int türden bir sayıyı ilgili sayı sisteminde
    ekrana (stdout) yazdıran metodun recursive versiyonu.
    Not: Metotta ikiye tümleme işlemine yönelik negatif sayıların gösterilişi yapılmamıştır. Bu durum bitsel operatörler
    konusu içerisinde ayrıca ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.console.Console;
import org.csystem.util.recursion.RecursionUtil;
import org.csystem.util.recursion.Util;

public class RecursiveWriteNumberTest {
    public static void run()
    {
        for (;;) {
            var val = Console.readInt("Bir sayı giriniz:");
            var radix = Console.readUInt("Sayı sistemini giriniz:");

            RecursionUtil.writeNumber(val, radix);
            Console.writeLine();

            if (val == 0)
                break;
        }
    }
}
