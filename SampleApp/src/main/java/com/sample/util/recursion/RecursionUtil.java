package com.sample.util.recursion;

import org.csystem.util.console.Console;

public class RecursionUtil {

    private static int fibonacciNumberRecur(int n)
    {
        if (n <= 2)
            return n - 1;

        return fibonacciNumberRecur(n - 1) + fibonacciNumberRecur(n - 2);
    }

    private static int gcdRecur(int a, int b)
    {
        return b == 0 ? a : gcdRecur(b, a % b);
    }

    private static void reverseRecur(char[] chars, int left, int right)
    {
        if (left >= right)
            return;

        var temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

        reverseRecur(chars, ++left, --right);
    }

    private static void writeNumberRecur(int val, int radix)
    {
         if (val / radix != 0)
            writeNumberRecur(val / radix, radix);

        System.out.write((char)((val % radix >= 10 ? 'A' - 10 : '0') + val % radix));
    }

    private  static void writeReverseRecur(String s, int i)
    {
        if(i == s.length())
            return;

        writeReverseRecur(s, i + 1);
        Console.write(s.charAt(i));
    }

    public static long factorial(int n)
    {
        long result;

        if(n <= 0)
            return 1;

        result = n * factorial(n - 1);

        return result;
    }

    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        return fibonacciNumberRecur(n);
    }

    public static int gcd(int a, int b)
    {
        return gcdRecur(Math.abs(a), Math.abs(b));
    }

    public static String reverse(String s)
    {
        char chars [] = s.toCharArray();

        reverseRecur(chars, 0, s.length() - 1);

        return String.valueOf(chars);
    }

    public static void writeCollatz(int n)
    {
        Console.writeLine(n);

        if (n > 1)
            writeCollatz(n % 2 == 0 ? n / 2 : 3 * n + 1);
    }

    public static void writeNumber(int val, int radix)
    {
        if (val < 0) {
            System.out.write('-');
            val = - val;
        }
        writeNumberRecur(val, radix);
        System.out.flush();
    }
    public static void writeReverse(String s)
    {
        writeReverseRecur(s, 0);
        System.out.flush();
    }

}
