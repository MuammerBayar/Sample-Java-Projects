package com.sample.util.recursion.test;

import com.sample.util.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveWriteCollatzTest {
    public static void run()
    {
        for(;;){
            var a = Console.readInt("Input a number:");

            if (a == 0)
                break;

            RecursionUtil.writeCollatz(a);
        }
    }
}
