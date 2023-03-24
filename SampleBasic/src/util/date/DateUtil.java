/*----------------------------------------------------------------------------------------------------------------------
    DateUtil Sınıfı
    last update:21.03.2023
----------------------------------------------------------------------------------------------------------------------*/
package util.date;

public class DateUtil {
    public static void displayDateTR(int day, int month, int year)
    {
        int dayOfWeek = getDayOfWeek(day, month, year);
        if (dayOfWeek == -1) {
            System.out.println("Geçersiz tarih");
            return;
        }

        switch (dayOfWeek) {
            case 0:
                System.out.printf("%02d/%02d/%04d Pazar%n", day, month, year);
                break;
            case 1:
                System.out.printf("%02d/%02d/%04d Pazartesi%n", day, month, year);
                break;
            case 2:
                System.out.printf("%02d/%02d/%04d Salı%n", day, month, year);
                break;
            case 3:
                System.out.printf("%02d/%02d/%04d Çarşamba%n", day, month, year);
                break;
            case 4:
                System.out.printf("%02d/%02d/%04d Perşembe%n", day, month, year);
                break;
            case 5:
                System.out.printf("%02d/%02d/%04d Cuma%n", day, month, year);
                break;
            case 6:
                System.out.printf("%02d/%02d/%04d Cumartesi%n", day, month, year);
                break;
        }
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

    public static int getTotalDays(int month, int year)
    {
        int totalDays = 0;
        switch (month - 1) {
            case 12:
                totalDays += 31;
            case 11:
                totalDays += 30;
            case 10:
                totalDays += 31;
            case 9:
                totalDays += 30;
            case 8:
                totalDays += 31;
            case 7:
                totalDays += 31;
            case 6:
                totalDays += 30;
            case 5:
                totalDays += 31;
            case 4:
                totalDays += 30;
            case 3:
                totalDays += 31;
            case 2:
                totalDays += 28;
                if(isLeapYear(year))
                    ++totalDays;
            case 1:
                totalDays += 31;
        }

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

        int days = 31;
        switch (month) {
            case 11:
            case 9:
            case 6:
            case 4:
                days = 30;
                break;
            case 2:
                days = 28;
                if (isLeapYear(year))
                    ++days;
                break;
        }
        return day <= days;
    }
    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}