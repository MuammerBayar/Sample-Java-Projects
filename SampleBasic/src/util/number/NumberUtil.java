/*----------------------------------------------------------------------------------------------------------------------
    NumberUtil Sınıfı
    last update:21.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package util.number;

public class NumberUtil {
    public static int countDigits(int val)
    {
        int count = 0;

        do {
            ++count;
            val /= 10;
        } while (val != 0);

        return count;
    }
    public static int factorial(int val)
    {
        int result = 1;

        for (int i = 2; i <= val; ++i)
            result *= i;

        return result;
    }

    public static int gcd(int a, int b)
    {
        int devider = Math.min(a,b);

        if (Math.max(a,b) % devider == 0)
            return devider;
        else
            devider /= 2;

        for (;;) {

            if (a % devider == 0 && b % devider == 0)
                return devider;

            --devider;
        }
    }

    public static int getFibonacciNumber(int n)
    {

        if (n < 0)
            return 0;

        int prev2 = 0, prev1 = 1;

        if (n < 2)
            return n - 1;

        for (int i = 2; i < n; ++i) {
            int temp = prev1;
            prev1 += prev2;
            prev2 = temp;
        }

        return prev1;
    }

    public static int getNextFibonacciNumber(int val)
    {
        if (val < 0)
            return 0;

        int prev2 = 0, prev1 = 1;
        int result = prev1 + prev2;

        for (;;) {

            prev2 = prev1;
            prev1 = result;

            if (result > val )
                return result;

            result = prev1 + prev2;
        }
    }

    public static int getPrime(int n)
    {
        int count = 0;
        int result = 0;

        for (int i = 2; count != n; ++i)
            if (isPrime(i)) {
                ++count;
                result = i;
            }

        return result;

    }
    public static boolean isArmstrong(int val)
    {
        if (val < 0)
            return false;

        int temp = val;
        int result = 0;
        int countDigits = countDigits(val);

        while (temp != 0) {
            result += Math.pow(temp % 10, countDigits);
            temp /= 10;
        }

        if(val == result)
            return true;

        return false;
    }
    public static boolean isPrime(long val)
    {
        if (val < 2)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        for (long i = 11; i * i <= val; i += 2)
            if (val % i == 0)
                return false;

        return true;
    }
    public static int reversed(int val)
    {
        int result = 0;

        while (val != 0) {
            result = result *  10 + val % 10;
            val /= 10;
        }

        return result;
    }
    public static int sumDigits(int val)
    {
        val = Math.abs(val);

        int sum = 0;
        while (val != 0) {
            sum += val % 10;
            val /= 10;
        }

        return sum;
    }
}
