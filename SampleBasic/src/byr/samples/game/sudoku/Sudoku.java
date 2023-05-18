/*----------------------------------------------------------------------------------------------------------------------
	 Sudoku class
	 çözüm tarihi: 18.05.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.game.sudoku;

import java.util.Scanner;

public class Sudoku {
    private final int [][] m_sdm;

    private boolean checkColumns()
    {
        for (int[] col : m_sdm) {
            boolean [] numbers = new boolean[10];

            for (int k = 0; k < col.length; ++k)
                if (!numbers[col[k]])
                    numbers[col[k]] = true;
                else
                    return false;
        }
        return true;
    }


    private boolean checkRows()
    {

        for (int i = 0; i < m_sdm[0].length; ++i) {
            boolean [] numbers = new boolean[10];

            for (int k = 0; k < m_sdm.length; ++k)
                if (!numbers[m_sdm[k][i]])
                    numbers[m_sdm[k][i]] = true;
                else
                    return false;
        }
        return true;
    }
    // 9x9 sudoku için yazılmıştır, genelleştirilebilir
    private boolean checkSmallMatrices()
    {
        for (int row = 0; row <= m_sdm.length - 3; row += 3)
               for (int col = 0; col <= m_sdm[0].length - 3; col += 3) {
                   boolean [] numbers = new boolean[10];

                   for (int i = row; i < row + 3; ++i)
                       for (int k = col; k < col + 3; ++k)
                           if (!numbers[m_sdm[i][k]])
                               numbers[m_sdm[i][k]] = true;
                           else
                               return false;
               }

        return true;
    }

    public Sudoku()
    {
        m_sdm = new int[9][9];
    }

    public void read()
    {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < m_sdm.length; ++i)
            for (int k = 0; k < m_sdm[i].length; ++k){
                System.out.printf("%d. satır %d. sütun:", i + 1 , k + 1);
                m_sdm[i][k] = Integer.parseInt(kb.nextLine());
            }

    }

    public boolean isValid()
    {
        return checkColumns() && checkRows() && checkSmallMatrices();
    }
}
