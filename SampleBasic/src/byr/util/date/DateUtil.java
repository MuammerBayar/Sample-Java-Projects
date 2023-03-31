/*----------------------------------------------------------------------------------------------------------------------
    DateUtil Sınıfı
    last update:31.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.util.date;

import java.util.Random;

public class DateUtil {
    public static int [] dayOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, };

    public static String [] MONTHS_EN = {"", "January", "February", "March", "April", "May", "Jul",
                                            "July", "August", "September", "October", "November", "December", };
    public static String [] DAY_OF_WEEK_TR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};

    public static void displayDateTR(int day, int month, int year)
    {
        int dayOfWeek = getDayOfWeek(day, month, year);
        if (dayOfWeek == -1) {
            System.out.println("Geçersiz tarih");
            return;
        }

        System.out.printf("%02d/%02d/%04d %s%n", day, month, year, DAY_OF_WEEK_TR[dayOfWeek]);

        if (isWeekend(day, month, year))
            System.out.println("Bugün kurs var tekrara yaptınız mı?");
        else
            System.out.println("Kurs günü yaklaşıyor. Tekrar yapmayı unutmayınız");
    }
    public static int getDayOfWeek(int day, int month, int year)
    {
        if(!isValidDate(day, month, year) || year < 1900)
            return -1;

        int totalDays = getDayOfYear(day, month, year);

        for (int i = 1900; i < year; ++i) {
            totalDays += 365;

            if (isLeapYear(i))
                ++totalDays;
        }

        return totalDays % 7;
    }

    public static int getDayOfYear(int day, int month, int year)
    {
        if (!isValidDate(day, month, year))
            return -1;

        return day + getTotalDays(month,year);
    }

    public static String getNumberFurther(int day)
    {
        String further = "th";

        switch (day % 10) {
            case 1:
                further = "st";
                break;
            case 2:
                further = "nd";
                break;
            case 3:
                further = "rd";
                break;
        }

        return further;
    }

    public static int getTotalDays(int month, int year)
    {
        int totalDays = 0;

        for (int i = 1; i < month; ++i)
            totalDays += dayOfMonths[i];

        if (month > 2 && isLeapYear(year))
            ++totalDays;

        return totalDays;
    }
    public static boolean isWeekend(int day, int month, int year)
    {
        int dayOfWeek = getDayOfWeek(day, month, year);
        return dayOfWeek == 0 || dayOfWeek == 6;
    }
    public static boolean isWeekday(int day, int month, int year)
    {
        return !isWeekend(day, month, year);
    }
    public static boolean isValidDate(int day,int month, int year)
    {
        if(day < 1 || day > 31 || month < 1 || month > 12)
            return false;

        int days = dayOfMonths[month];

        if (month == 2 && isLeapYear(year))
            ++days;

        return day <= days;
    }
    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }


    public static void printRandomDate()
    {
        Random r = new Random();

        int month = r.nextInt(12) + 1;
        int year = r.nextInt(2100 - 1900 + 1) + 1900; //[1900,2100]
        int day = r.nextInt(dayOfMonths[month]) + 1;

        if (r.nextBoolean() && isLeapYear(year) && month == 2)
            ++day;

        System.out.printf("%d%s %s %d%n",day, getNumberFurther(day), MONTHS_EN[month], year);
    }
}
