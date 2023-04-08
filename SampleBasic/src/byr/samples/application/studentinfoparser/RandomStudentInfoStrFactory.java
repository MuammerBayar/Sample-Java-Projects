package byr.samples.application.studentinfoparser;

import java.util.Random;

public class RandomStudentInfoStrFactory {
    public String [] studentsInfo;
    public boolean [] flags;
    public int count;
    public Random random;

    public void init()
    {
        studentsInfo = new String[] {
                "Muammer bayar:10/09/1976:Matematik:40:55",
                "Erkam doğrul:10/07/2001:Matematik:90:65",
                "Cihan Başar:15/01/1997:Matematik:90:95",
                "Bora Bakırtaş:19/01/2000:Matematik:90:99",
        };
        flags = new boolean[studentsInfo.length];
    }

    public RandomStudentInfoStrFactory()
    {
        random = new Random();
        init();
    }

    public int getNumberOfStudents()
    {
        return studentsInfo.length;
    }

    public String getRandomStudentInfoStr()
    {
        if (count == studentsInfo.length)
            return "";
        int index;

        for (;;) {
            index = random.nextInt(studentsInfo.length);

            if (!flags[index])
                break;
        }
        ++count;
        flags[index] = true;

        return studentsInfo[index];
    }
}