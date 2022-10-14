package com.sample.util.recursion.test;

import com.sample.util.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveFactorialTest {
    public static void run()
    {
        for (var n = 0; n < 13; ++n)
            Console.writeLine("%d! = %d", n, RecursionUtil.factorial(n));
    }
}
