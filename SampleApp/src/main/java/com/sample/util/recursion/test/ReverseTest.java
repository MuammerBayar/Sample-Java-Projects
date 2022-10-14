package com.sample.util.recursion.test;

import com.sample.util.recursion.Util;
import org.csystem.util.console.Console;

public class ReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("input a text:");

            var rev = Util.reverse(s);
            Console.writeLine(rev);

            if("quit".equals(s))
                break;
        }
    }
}
