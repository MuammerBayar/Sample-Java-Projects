package byr.samples.application.io.file;

import java.io.File;

public class FileDeleteApp {

    private static void deleteFile(File dir)
    {
        for (File file : dir.listFiles())
            System.out.println(file.delete() ? "success" : "fail");
    }

    private FileDeleteApp()
    {
    }

    public static void run(String [] args)
    {
        if (args.length != 1) {
            System.err.println("wrong number of arguments");
            System.exit(1);
        }

        File dir = new File(args[0]);

        if (dir.exists()) {
            if (dir.isDirectory())
                deleteFile(dir);
            else
                System.out.printf("'%s' not directory%n", dir.getAbsolutePath());
        }
        else
            System.out.printf("'%s' not exists%n", dir.getAbsolutePath());
    }
}
