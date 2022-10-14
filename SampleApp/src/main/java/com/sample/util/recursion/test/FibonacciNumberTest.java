package com.sample.util.recursion.test;

import com.sample.util.recursion.Util;
import org.csystem.util.console.Console;

public class FibonacciNumberTest {
    public static void run()
    {
        for(;;){
            var n = Console.readInt("Input a number:");

            if (n <= 0)
                break;

            var val = Util.fibonacciNumber(n);

            Console.writeLine("%d. fibonacci number:%d", n, val);
        }

    }
}
