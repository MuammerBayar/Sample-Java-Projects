/*----------------------------------------------------------------------------------------------------------------------
    CommandPrompt Sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.commandprompt;

import byr.util.string.StringUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandPrompt {
    private final String [] m_commands = {"length", "reverse", "upper", "lower", "chprom",
            "tget","tjoin","tclear","tprint","quit"};

    private final ArrayList m_elems;
    private final Scanner m_kb = new Scanner(System.in);

    private String m_prompt;

    private static final int numberOfArgs = 2;

    private static boolean checkSeparator(String cmdText, String sep)
    {
        cmdText = cmdText.trim();
        int firstIdx = cmdText.indexOf(sep);
        int lastIdx = cmdText.lastIndexOf(sep);

        if (lastIdx != cmdText.length() - 1)
            return false;

        return firstIdx > 2 && firstIdx != lastIdx;
    }

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

    private void tGetProc(String [] cmdInfo)
    {
        if (cmdInfo.length == 1) {
            System.out.println("tget command must have at least one argument");
            return;
        }
        Scanner kb = new Scanner(System.in);

        String exitText = StringUtil.join(cmdInfo,1," ");

        for (;;) {
            System.out.printf("Please enter [%s] for exit%n", exitText);
            System.out.print("text: ");
            String text = kb.nextLine();

            if (exitText.equals(text))
                break;

            m_elems.add(text);
        }

    }

    private void tJoinProc(String [] cmdInfo)
    {
        if (m_elems.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        String delimiter = cmdInfo.length == 1 ? " " : StringUtil.join(cmdInfo,1," ");

        System.out.printf("Joined text: %s%n",StringUtil.join(m_elems,delimiter));

    }

    private void tClearProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 1) {
            System.out.println("tclear command can not have any argument");
            return;
        }

        m_elems.clear();
    }

    private void tPrintProc(String [] cmdInfo)
    {
        if (cmdInfo.length != 1) {
            System.out.println("tprint command can not have any argument");
            return;
        }

        System.out.println(m_elems);
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

        String [] cmdInfo = cmdText.split("[ \t\"]+");

        if (cmdInfo.length == 1 && cmdInfo[0].equals(""))
            return;

        if (cmdInfo.length != 1 && !checkSeparator(cmdText, "\"")) {
            System.out.println("Use of separator is incorrect");
            return;
        }

        if (cmdInfo[0].length() < 3) {
            System.out.println("Any command must include at least 3(three) character");
            return;
        }

        int index = StringUtil.indexOfStartsWith(m_commands, cmdInfo[0]);

        if (index != -1) {
            cmdInfo[0] = m_commands[index];
            this.doWorkForCommand(cmdInfo);
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
                this.changePromptProc(cmdInfo);
                break;
            case "tget":
                this.tGetProc(cmdInfo);
                break;
            case "tjoin":
                this.tJoinProc(cmdInfo);
                break;
            case "tclear":
                this.tClearProc(cmdInfo);
                break;
            case "tprint":
                this.tPrintProc(cmdInfo);
                break;
            case "quit":
                quitProc(cmdInfo);
                break;
        }
    }

    public CommandPrompt(String p)
    {
        m_prompt = p;
        m_elems = new ArrayList();
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
