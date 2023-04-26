/*----------------------------------------------------------------------------------------------------------------------
    ExamSimulation Sınıfı
    TODO:
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.examsimulation;

import byr.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    private String m_lectureName;
    private int [][] m_grades;
    private double [] m_averages;
    private double m_average;

    private final Scanner m_kb = new Scanner(System.in);

    private void fillRandomGrades()
    {
        Random r = new Random();
        int totalGrades = 0;
        int numberOfStudents = 0;
        System.out.print("Şube sayısı: ");
        m_grades = new int[Integer.parseInt(m_kb.nextLine())][];
        m_averages = new double[m_grades.length];

        for (int i = 0; i < m_grades.length; ++i){
            System.out.printf("%d şube öğrenci sayısı: ", i + 1);
            int n = Integer.parseInt(m_kb.nextLine());
            numberOfStudents += n;

            m_grades[i] = ArrayUtil.getRandomArray(r,n, 0, 100);
            m_averages[i] = ArrayUtil.average(m_grades[i]);
            totalGrades += ArrayUtil.sum(m_grades[i]);
        }

        m_average = (double) totalGrades / numberOfStudents;
    }

    private void setExamInfos()
    {
        if (m_lectureName.isBlank()){
            System.out.println("Ders adı:");
            m_lectureName = m_kb.nextLine();
        }




    }

    public ExamSimulation(String lectureName)
    {
        m_lectureName = lectureName;
    }




}
