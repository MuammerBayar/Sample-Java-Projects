/*----------------------------------------------------------------------------------------------------------------------
    StringUtil Sınıfı
    last update:21.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package util.stringUtil;

public class StringUtil {
    public static int countString(String s1, String s2)
    {
        int count = 0;
        int index = -1;
        while ((index = s1.indexOf(s2, index + 1)) != -1)
            ++count;

        return count;
    }

    public static int countStringIgnoreCase(String s1, String s2)
    {
        return countString(s1.toLowerCase(), s2.toLowerCase());
    }
    public static String reversed(String s)
    {
        int length = s.length();
        String str = "";
        for (int i = 0; i < length; ++i) {
            str += s.charAt(length - 1 - i);
        }
        return str;
    }
}
