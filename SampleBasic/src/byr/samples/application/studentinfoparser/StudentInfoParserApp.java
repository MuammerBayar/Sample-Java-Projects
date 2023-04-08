package byr.samples.application.studentinfoparser;

public class StudentInfoParserApp {
    public static void run()
    {
        RandomStudentInfoStrFactory factory = new RandomStudentInfoStrFactory();
        StudentInfo [] randomStudents = new StudentInfo[factory.getNumberOfStudents()];

        for (int i = 0; i < randomStudents.length; ++i) {

            StudentInfo studentInfo = StudentInfo.parse(factory.getRandomStudentInfoStr());
            //...
            randomStudents[i] = studentInfo;
        }

        for (int i = 0; i < randomStudents.length; ++i)
            System.out.println(randomStudents[i].toString());
    }
}