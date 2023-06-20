package byr.samples.application.parser;

import java.util.Scanner;

public final class ParserStdInSourceApp {
    private ParserStdInSourceApp()
    {

    }

    private static void run()
    {
        Scanner kb = new Scanner(System.in);
        Parser parser = new Parser();

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String s = kb.nextLine();

            if ("elma".equals(s))
                break;

            StringSource ss = new StringSource(s);
            CharArraySource cs = new CharArraySource(s);

            parser.setSource(ss);

            System.out.printf("Rakam sayısı:%d%n", parser.countDigits());
            System.out.printf("Boşluk sayısı:%d%n", parser.countWhitespaces());
            System.out.println("--------------------");

            parser.setSource(cs);

            System.out.printf("Rakam sayısı:%d%n", parser.countDigits());
            System.out.printf("Boşluk sayısı:%d%n", parser.countWhitespaces());
            System.out.println("--------------------");
        }
    }
}
