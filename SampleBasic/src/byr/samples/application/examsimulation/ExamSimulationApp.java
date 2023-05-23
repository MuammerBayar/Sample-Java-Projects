/*----------------------------------------------------------------------------------------------------------------------
    ExamSimulationApp Sınıfı
    TODO:
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.examsimulation;

public final class ExamSimulationApp {

    private ExamSimulationApp()
    {

    }
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
