package com.sample.util.recursion.test;

import com.sample.util.recursion.Util;
import org.csystem.util.console.Console;

public class FactorialTest {
    public static void run()
    {
        for (var n = 0; n < 13; ++n)
            Console.writeLine("%d! = %d", n, Util.factorial(n));
    }
}
