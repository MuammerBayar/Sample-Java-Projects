package com.sample.util.recursion.test;

import com.sample.util.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("input a text:");

            var rev = RecursionUtil.reverse(s);
            Console.writeLine(rev);

            if("quit".equals(s))
                break;
        }
    }
}
