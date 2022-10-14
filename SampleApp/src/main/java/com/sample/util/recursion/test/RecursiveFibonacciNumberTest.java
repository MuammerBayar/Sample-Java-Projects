package com.sample.util.recursion.test;

import com.sample.util.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveFibonacciNumberTest {
    public static void run()
    {
        for(;;){
            var n = Console.readInt("Input a number:");

            if (n <= 0)
                break;

            var val = RecursionUtil.fibonacciNumber(n);

            Console.writeLine("%d. fibonacci number:%d", n, val);
        }

    }
}
