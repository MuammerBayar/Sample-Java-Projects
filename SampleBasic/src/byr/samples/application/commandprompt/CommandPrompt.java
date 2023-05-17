/*----------------------------------------------------------------------------------------------------------------------
    CommandPrompt Sınıfı

    iskelettir.
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.commandprompt;

import byr.util.string.StringUtil;

import java.util.Scanner;

public class CommandPrompt {
    private final String [] m_commands = {"length", "reverse", "upper", "lower", "chprom", "quit"};
    private final Scanner m_kb = new Scanner(System.in);
    private String m_prompt;

    private static final int numberOfArgs = 2;

    private static void lengthProc(String [] cmdInfo)
    {
        if (cmdInfo.length == 1) {
            System.out.println("length command must have at least one argument");
            return;
        }

        String args = StringUtil.join(cmdInfo, 1, "");

        System.out.printf("Length without whitespaces:%d%n", args.length());
    }

    private static void reverseProc(String [] cmdInfo)
    {
        if (cmdInfo.length == 1) {
            System.out.println("reverse command must have at least one argument");
            return;
        }

        String args = StringUtil.join(cmdInfo, 1, ' ');
        System.out.printf("Reverse with a space delimiter: %s%n", StringUtil.reverse(args));
    }

    private static void upperProc(String [] cmdInfo)
    {
        if (cmdInfo.length == 1) {
            System.out.println("upper command must have at least one argument");
            return;
        }

        String args = StringUtil.join(cmdInfo, 1, ' ');
        System.out.printf("Upper with a space delimiter: %s%n", args.toUpperCase());
    }

    private static void lowerProc(String [] cmdInfo)
    {
        if (cmdInfo.length == 1) {
            System.out.println("lower command must have at least one argument");
            return;
        }

        String args = StringUtil.join(cmdInfo, 1, ' ');
        System.out.printf("Lower with a space delimiter: %s%n", args.toLowerCase());
    }

    private static void quitProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 1) {
            System.out.println("quit command can not have any argument");
            return;
        }
        System.out.println("C and System Programmers Association");
        System.out.println("Thank you");
        System.exit(0);
    }

    private void changePromptProc(String [] cmdInfo)
    {
        if (cmdInfo.length == 1) {
            System.out.print("Input a text:");
            String p = m_kb.nextLine();

            if (!p.isBlank())
                m_prompt = p.trim();
            else
                System.out.println("Text must include at least one character without whitespace");
        }
        else
            m_prompt = StringUtil.join(cmdInfo, 1, ' ');
    }

    private void parseCommand(String cmdText)
    {

        String [] cmdInfo = cmdText.split("[ \t]+");

        if (cmdInfo.length == 1 && cmdInfo[0].equals(""))
            return;

        if (cmdInfo[0].length() < 3) {
            System.out.println("Any command must include at least 3(three) character");
            return;
        }

        int index = StringUtil.indexOfStartsWith(m_commands, cmdInfo[0]);

        if (index != -1) {
            // argüman almayan commandler ne olacak ?
            String [] args = getArguments(cmdText);

            if (args == null)
                return;

            cmdInfo = new String[numberOfArgs + 1];

            cmdInfo[0] = m_commands[index];
            for (int i = 1; i < args.length; ++i)
                cmdInfo[i + 1] = args[i];

            doWorkForCommand(cmdInfo);
        }
        else
            System.out.println("Invalid command");
    }

    private void doWorkForCommand(String [] cmdInfo)
    {
        switch (cmdInfo[0]) {
            case "length":
                lengthProc(cmdInfo);
                break;
            case "reverse":
                reverseProc(cmdInfo);
                break;
            case "upper":
                upperProc(cmdInfo);
                break;
            case "lower":
                lowerProc(cmdInfo);
                break;
            case "chprom":
                changePromptProc(cmdInfo);
                break;
            case "quit":
                quitProc(cmdInfo);
                break;
        }
    }

    private static String [] getArguments(String text)
    {
        String [] args = new String[numberOfArgs];
        int count = 0, firstIdx, secondIdx;

        text = text.trim();
        int len = text.length();

        for (int i = 0; i < len; i = secondIdx + 1) {
            firstIdx = text.indexOf("\"", i);

            if (firstIdx == -1) {
                System.out.println("argument must be between double quote");
                return null;
            }
            secondIdx = text.indexOf("\"", firstIdx + 1);

            if (secondIdx == -1){
                System.out.println("argument must be between double quote");
                return null;
            }

            args[count++] = text.substring(firstIdx + 1, secondIdx);
        }

        return args;
    }

    public CommandPrompt(String p)
    {
        m_prompt = p;
    }

    public void run()
    {
        for (;;) {
            System.out.print(m_prompt + ">");
            String cmdText = m_kb.nextLine().trim();

            parseCommand(cmdText);
        }
    }
}
