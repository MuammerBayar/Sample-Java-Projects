package com.sample.util.recursion.test;

import com.sample.util.recursion.Util;
import org.csystem.util.console.Console;

public class GCDTest {
    public static void run()
    {
        for(;;){
            var a = Console.readInt("Input first number:");

            if (a == 0)
                break;

            var b = Console.readInt("Input second number:");

            Console.writeLine("GCD:%d", Util.gcd(a, b));
        }
    }
}
