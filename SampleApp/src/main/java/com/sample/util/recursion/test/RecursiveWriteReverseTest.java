package com.sample.util.recursion.test;

import com.sample.util.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveWriteReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("input a text:");

            RecursionUtil.writeReverse(s);
            Console.writeLine();

            if("quit".equals(s))
                break;
        }
    }
}
