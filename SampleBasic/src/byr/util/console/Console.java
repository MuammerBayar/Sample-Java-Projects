package byr.util.console;

import java.util.Scanner;

public class Console {
    private static Scanner KB = new Scanner(System.in);
    private Console()
    {

    }

    // Int Read
    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String message)
    {
        return readInt(message, "");
    }

    public static int readInt(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);
                return Integer.parseInt(KB.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(errMessage);
            }
        }
    }

    public static int readIntLine()
    {
        return readIntLine("");
    }

    public static int readIntLine(String message)
    {
        return readIntLine(message,"");
    }

    public static int readIntLine(String message, String errMessage)
    {
        return readInt(message + "\n", errMessage + "\n");
    }


    // Double Read
    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String message)
    {
        return readDouble(message, "");
    }

    public static double readDouble(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);
                return Double.parseDouble(KB.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(errMessage);
            }
        }
    }

    public static double readDoubleLine()
    {
        return readDoubleLine("");
    }

    public static double readDoubleLine(String message)
    {
        return readDouble(message + "\n", "");
    }

    public static double readDoubleLine(String message, String errMessage)
    {
        return readDouble(message + "\n", errMessage + "\n");
    }

    //...
}
