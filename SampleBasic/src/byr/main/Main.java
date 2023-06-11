/*----------------------------------------------------------------------------------------------------------------------
    izlence(oop): 53.
----------------------------------------------------------------------------------------------------------------------*/
package byr.main;

import byr.util.console.Console;

class Main {
    public static void main(String[] args)
    {
        int a = Console.readInt("Birinci sayıyı giriniz:", "hatalı giriş");
        int b = Console.readInt("İkinci sayıyı giriniz:", "hatalı giriş");

        System.out.printf("%d + %d = %d%n", a, b, a + b);
    }
}