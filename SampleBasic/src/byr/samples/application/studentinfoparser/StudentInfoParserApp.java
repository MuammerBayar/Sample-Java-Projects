package byr.samples.application.studentinfoparser;
public class StudentInfoParserApp {
    private StudentInfoParserApp()
    {
    }

    public static void run()
    {
        RandomStudentInfoStrFactory factory = new RandomStudentInfoStrFactory();
        StudentInfo [] randomStudents = new StudentInfo[factory.getNumberOfStudents()];

        for (int i = 0; i < randomStudents.length; ++i) {

            StudentInfo studentInfo = StudentInfoParser.parse(factory.getRandomStudentInfoStr());
            //...
            randomStudents[i] = studentInfo;
        }

        for (int i = 0; i < randomStudents.length; ++i)
            System.out.println(randomStudents[i].toString());
    }
}
