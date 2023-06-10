package byr.samples.application.arraylisttoxml;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListToXML {
    private final ArrayList m_list = new ArrayList();

    private void addList(String [] names)
    {
        if (names.length == 0)
            return;

        m_list.add(names);
    }

    private void display()
    {
        System.out.println("<Names>");

        int size = m_list.size();

        for (int i = 0; i < size; ++i) {
            System.out.printf("\t<Line>%n");

            String [] names = (String [])m_list.get(i);

            for (int j = 0; j < names.length; ++j)
                System.out.printf("\t\t<Name>%s</Name>%n",names[j]);

            System.out.printf("\t</Line>%n");
        }

        System.out.println("</Names>");
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);
        String prompt = "text";
        for (;;) {
            System.out.print(prompt + ">");
            String names = kb.nextLine();

            if (names.equals("exit"))
                break;

            addList(names.split("[ ]+"));
        }

        display();
    }
}
