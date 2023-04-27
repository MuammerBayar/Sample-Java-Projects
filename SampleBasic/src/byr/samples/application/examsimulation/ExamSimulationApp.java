/*----------------------------------------------------------------------------------------------------------------------
    ExamSimulationApp Sınıfı
    TODO:
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.examsimulation;

public class ExamSimulationApp {
    public static void run()
    {
        ExamSimulation mathExam = new ExamSimulation("Matematik");
        ExamSimulation physicExam = new ExamSimulation("Fizik");

        mathExam.run();
        physicExam.run();

        mathExam.displayReport();
        physicExam.displayReport();
    }
}
