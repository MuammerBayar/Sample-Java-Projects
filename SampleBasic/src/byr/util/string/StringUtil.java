/*----------------------------------------------------------------------------------------------------------------------
    StringUtil Sınıfı
    last update:24.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.util.string;

import java.util.Random;

public class StringUtil {
    public static String capitalize(String s)
    {
        return s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String capitalizeWS(String s)
    {
        int i;
        int length = s.length();
        for (i = 0; i < length && Character.isWhitespace(s.charAt(i)); ++i)
            ;

        return i == length ? "" : s.substring(0,i) + Character.toUpperCase(s.charAt(i))  + s.substring(i + 1).toLowerCase();
    }

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

    public static String getLongestPalindrome(String str)
    {
        String maxPalindrome = "";

        for (int i = str.length() - 1; i > 0; --i)
            for (int k = 0; k < i; ++k) {
                String s = str.substring(k, i);

                if (s.length() != 1 && isPalindrome(s) &&  s.length() > maxPalindrome.length())
                    maxPalindrome = s;
            }

        return maxPalindrome;
    }

    public static String getRandomTextTR(Random r, int n)
    {
        return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ");
    }

    public static String getRandomTextTR(int n)
    {
        return getRandomTextTR(new Random(), n);
    }

    public static String getRandomTextEN(Random r, int n)
    {
        return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyzABCDEFGHIJKLMNOPQRSTUWXVYZ");
    }

    public static String getRandomTextEN(int n)
    {
        return getRandomTextEN(new Random(), n);
    }

    public static String getRandomText(Random r, int n, String sourceText)
    {
        String result = "";
        int length = sourceText.length();

        for (int i = 0; i < n; ++i)
            result += sourceText.charAt(r.nextInt(length));

        return result;
    }

    public static boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cLeft = Character.toLowerCase(s.charAt(left));

            if (!Character.isLetter(cLeft)) {
                ++left;
                continue;
            }
            char cRight = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetter(cRight)) {
                --right;
                continue;
            }
            if (cLeft != cRight)
                return false;

            ++left;
            --right;
        }

        return true;
    }

    public static boolean isPangramTR(String text)
    {
        return isPangram(text.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
    }

    public static boolean isPangramEN(String text)
    {
        return isPangram(text.toLowerCase(), "abcdefghijklmnopqrstuvwxyz");
    }

    public static boolean isPangram(String text, String alphabet)
    {
        int len = alphabet.length();

        for (int i = 0; i < len; ++i)
            if (text.indexOf(alphabet.charAt(i)) == -1)
                return false;

        return true;
    }

    public static String padLeading(String text, int length, char ch)
    {
        if (text.length() < length)
            text = (ch + "").repeat(length - text.length()) + text;

        return text;
    }

    public static String padLeading(String text, int length)
    {
        return padLeading(text, length,' ');
    }

    public static String padTrailing(String text, int length, char ch)
    {
        if ( text.length() < length)
            text = text + (ch + "").repeat(length - text.length());

        return text;
    }

    public static String padTrailing(String text, int length)
    {
        return padTrailing(text, length,' ');
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

    public static String repeat(int n , char ch)
    {
        return String.format("%0" + n + "d", 0).replace('0', ch);
    }
}
