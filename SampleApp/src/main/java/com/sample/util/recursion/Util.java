package com.sample.util.recursion;

import org.csystem.util.console.Console;

public class Util {
    public static long factorial (int n)
    {
        long result = 1;

        for (var i = 1; i <= n; ++i)
            result *= i;

        return result;
    }
    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if(n <= 2)
            return n - 1;

        int prev1 = 0, prev2 = 1, result = 0;

        for (var i = 2; i < n; ++i) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }

    public static int gcd(int a, int b)
    {
        int min = Math.min(Math.abs(a),Math.abs(b));

        if (a % min == 0 && b % min == 0)
            return min;

        for (int i = min / 2 ; i > 2; --i)
            if (a % i == 0 && b % i == 0)
                return i;


        return 1;
    }

    public static String reverse(String s)
    {
        char chars [] = s.toCharArray();
        var right = chars.length - 1;
        var left = 0;

        while(left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return String.valueOf(chars);
    }

    public static void writeCollatz(int n)
    {
        for (;;) {
            Console.writeLine(n);

            if (n == 1)
                break;

            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
        }
    }

    public static void writeNumber(int val, int radix)
    {
        if (val == 0) {
            System.out.write('0');
            return;
        }

        char [] s = new char[11];
        int i;
        boolean isNegative = false;

        if (val < 0) {
            isNegative = true;
            val = -val;
        }

        for (i = 0; val != 0; ++i, val /= radix)
            s[i] = (char)((val % radix >= 10 ? 'A' - 10 : '0') + val % radix);

        if (isNegative)
            s[i++] = '-';

        for (--i; i >= 0; --i)
            System.out.write(s[i]);
    }

    public static void writeReverse(String s)
    {
        char chars [] = s.toCharArray();

        for (var i = chars.length -  1; i >= 0; --i)
            Console.write(chars[i]);
    }
}
