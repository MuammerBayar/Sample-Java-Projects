package com.sample.util.recursion.test;

import com.sample.util.recursion.Util;
import org.csystem.util.console.Console;

public class WriteCollatzTest {
    public static void run()
    {
        for(;;){
            var a = Console.readInt("Input a number:");

            if (a == 0)
                break;

            Util.writeCollatz(a);
        }
    }
}
