package com.sample.util.recursion.test;

import com.sample.util.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveWriteNumberTest {
    public static void run()
    {
        for(;;){
            var val = Console.readInt("Input a number:");
            var radix = Console.readUInt("ınput number system:");

            RecursionUtil.writeNumber(val, radix);
            Console.writeLine();

            if (val == 0)
                break;
        }
    }
}
