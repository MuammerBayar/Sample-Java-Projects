package byr.samples.application.asciiimage.asciiimageapp;

import byr.samples.application.asciiimage.arraylist.AsciiImage;

import java.util.Scanner;

public class AsciiImageApp {
    private static void checkStrLength(String [] img, String str)
    {
        if (img[0] != null && str.length() != img[0].length()) {
            System.out.println("INPUT MISMATCH");
            System.exit(1);
        }
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Enter number of lines:");
            int n = Integer.parseInt(kb.nextLine());

            String [] img =  new String[n];

            for (int i = 0; i < n; ++i) {
                System.out.printf("%d. line>", i + 1);
                String str = kb.nextLine();

                checkStrLength(img,str);

                img[i] = str;
            }

            AsciiImage asciiImage = new AsciiImage(img);

            System.out.println("Commands ->[transpose, display, flipv, quit]");

            for (;;) {
                System.out.print("command>");
                String command = kb.nextLine();

                switch (command) {
                    case "transpose":
                        asciiImage.transpose();
                        break;
                    case "display":
                        asciiImage.disp();
                        break;
                    case "flipv":
                        asciiImage.flipv();
                        break;

                    case "quit":
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Wrong Command.");
                }

            }

        }
    }

}
