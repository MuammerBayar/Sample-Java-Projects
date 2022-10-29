/*----------------------------------------------------------------------------------------------------------------------
    18. ders izlenmeden önce tekrar yap.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
         Sample s1 = new Sample(){

         };

         var s2 = new Sample() {

         };

         var s3 = new Sample(){

         };

         Console.writeLine(s1.getClass().getName());
         Console.writeLine(s2.getClass().getName());
         Console.writeLine(s3.getClass().getName());
    }
}

class Sample {

}