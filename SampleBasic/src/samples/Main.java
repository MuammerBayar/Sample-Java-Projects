/*----------------------------------------------------------------------------------------------------------------------
    izlenecek:15.video
----------------------------------------------------------------------------------------------------------------------*/
package samples;

public class Main {
    public static void main(String [] args)
    {
        DateUtilTest.run();
    }
}

class DateUtilTest {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Gün?");
            int day = Integer.parseInt(kb.nextLine());

            if (day == 0)
                break;

            System.out.print("Ay?");
            int month = Integer.parseInt(kb.nextLine());

            System.out.print("Yıl?");
            int year = Integer.parseInt(kb.nextLine());

            int dayOfYear = DateUtil.getDayOfYear(day, month, year);

            if (dayOfYear != -1)
                System.out.printf("%02d/%02d/%04d tarihi yılın %d. günüdür%n", day, month, year, dayOfYear);
            else
                System.out.println("Geçersiz tarih");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class DateUtil {

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