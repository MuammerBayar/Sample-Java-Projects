/*----------------------------------------------------------------------------------------------------------------------
    izlenecek (oop):27.video
    izlenecek (app): -
----------------------------------------------------------------------------------------------------------------------*/

package samples.main;

public class Main {
    public static void main(String [] args)
    {
        System.out.println(StringUtil.repeat(2, 'x'));
        System.out.println(StringUtil.repeat(3, 'x'));
        System.out.println(StringUtil.repeat(4, 'x'));
    }
}

class StringUtil {
    public static String repeat(int n , char ch)
    {
        return String.format("%0" + n + "d", 0).replace('0', ch);
    }
}