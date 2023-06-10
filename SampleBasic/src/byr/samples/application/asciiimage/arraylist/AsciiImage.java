package byr.samples.application.asciiimage.arraylist;

import java.util.ArrayList;

public class AsciiImage {
    private ArrayList m_image;


    private void fillMatrix(String [] img)
    {
        m_image = new ArrayList();

        for (String str : img)
            m_image.add(str);
    }
    public AsciiImage(String [] img)
    {
        fillMatrix(img);
    }

    public void transpose()
    {
        char [][] chars = new char[m_image.size()][];

        for (int i = 0; i < chars.length; ++i)
            chars[i] = ((String)m_image.get(i)).toCharArray();

        int length = ((String)m_image.get(0)).length();

        char [][] result = new char[length][m_image.size()];
        String [] newImg = new String[result.length];

        for (int i = 0; i < result.length ; ++i) {
            for (int k = 0; k < chars.length; ++k)
                result[i][k] = chars[k][result.length - 1 - i];

            newImg[i] = String.valueOf(result[i]);
        }

        fillMatrix(newImg);
    }
    public void disp()
    {
        for (Object object : m_image) {
            System.out.print((String) object);

            System.out.println();
        }
        int length = ((String)m_image.get(0)).length();
        System.out.printf("%d %d%n", length, m_image.size());
    }

    public void flipv()
    {
        int size = m_image.size();

        for (int i = 0; i < size / 2; ++i) {
            Object temp = m_image.get(i);
            m_image.set(i,m_image.get(size - 1 - i));
            m_image.set(size - 1 - i,temp);
        }
    }
}
