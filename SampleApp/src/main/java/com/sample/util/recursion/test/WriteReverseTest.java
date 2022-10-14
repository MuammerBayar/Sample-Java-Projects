package com.sample.util.recursion.test;

import com.sample.util.recursion.Util;
import org.csystem.util.console.Console;

public class WriteReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("input a text:");

            Util.writeReverse(s);
            Console.writeLine();

            if("quit".equals(s))
                break;
        }
    }
}
