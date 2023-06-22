package byr.samples.application.io.file;

import java.io.File;

public class FileListApp {

    private static void listFile(File file)
    {
        for (String name : file.list())
            System.out.println(name);
    }

    private FileListApp()
    {
    }

    public static void run(String [] args)
    {

        if (args.length != 1) {
            System.err.println("Wrong number of arguments");
            System.exit(1);
        }

        File dir = new File(args[0]);

        if (dir.exists()) {
            if (dir.isDirectory())
                listFile(dir);
            else
                System.out.printf("'%s' not directory%n", dir.getAbsolutePath());

        }
        else
            System.out.printf("'%s' not exists%n", dir.getAbsolutePath());

    }


}
