package byr.util.console;

import java.util.Scanner;

public final class CommandLineUtil {
    private static final Scanner ms_kb = new Scanner(System.in);
    private CommandLineUtil()
    {
    }

    public static boolean checkIfEqual(String [] args, int n)
    {
        return args.length == n;
    }

    public static boolean checkIfNotEqual(String [] args, int n)
    {
        return !checkIfEqual(args, n);
    }

    public static boolean checkIfGreater(String [] args, int n)
    {
        return args.length > n;
    }

    public static boolean checkIfLess(String [] args, int n)
    {
        return args.length < n;
    }

    public static boolean checkIfLessOrEqual(String [] args, int n)
    {
        return !checkIfGreater(args, n);
    }

    public static boolean checkIfGreaterOrEqual(String [] args, int n)
    {
        return !checkIfLess(args,n);
    }

    public static void checkIfEqualAndExit(String [] args, int n, String message)
    {
        if (checkIfEqual(args, n)) {
            System.out.println(message);
            System.exit(1);
        }
    }

    public static void checkIfNotEqualAndExit(String [] args, int n, String message)
    {
        if (checkIfNotEqual(args, n)) {
            System.out.println(message);
            System.exit(1);
        }
    }

    public static void checkIfLessAndExit(String [] args, int n, String message)
    {
        if (checkIfLess(args, n)) {
            System.out.println(message);
            System.exit(1);
        }
    }

    public static void checkIfGreaterAndExit(String [] args, int n, String message)
    {
        if (checkIfGreater(args, n)) {
            System.out.println(message);
            System.exit(1);
        }
    }
    public static void checkIfLessOrEqualAndExit(String [] args, int n, String message)
    {
        if (checkIfLessOrEqual(args, n)) {
            System.out.println(message);
            System.exit(1);
        }
    }

    public static void checkIfGreaterOrEqualAndExit(String [] args, int n, String message)
    {
        if (checkIfGreaterOrEqual(args, n)) {
            System.out.println(message);
            System.exit(1);
        }
    }

    public static String [] getArgumentsWithoutParse(String [] args, String prompt)
    {
        if (args.length != 0)
            return args;

        System.out.print(prompt);

        return new String[] {ms_kb.nextLine()};
    }

    public static String [] getArguments(String [] args, String prompt)
    {
        if (args.length != 0)
            return args;

        System.out.print(prompt);

        return ms_kb.nextLine().split("[ \t]+");
    }
}
