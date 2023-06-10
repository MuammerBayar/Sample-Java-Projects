package byr.samples.application.asciiimage.chararray;

public class AsciiImage {
    private char [][] m_image;


    private void fillMatrix(String [] img)
    {
        m_image = new char[img.length][];

        for (int i = 0; i < img.length; ++i)
                m_image[i] = img[i].toCharArray();
    }
    public AsciiImage(String [] img)
    {
        fillMatrix(img);
    }

    public void transpose()
    {

        char [][] result = new char[m_image[0].length][m_image.length];

        for (int i = 0; i < result.length ; ++i)
            for (int k = 0; k < m_image.length; ++k)
                result[i][k] = m_image[k][result.length - 1 - i];

        m_image = result;
    }
    public void disp()
    {
        for (char [] arr : m_image) {
            for (char ch : arr)
                System.out.print(ch);

            System.out.println();
        }

        System.out.printf("%d %d%n", m_image[0].length, m_image.length);
    }

    public void flipv()
    {
        for (int i = 0; i < m_image.length / 2; ++i) {
            char [] temp = m_image[i];
            m_image[i] = m_image[m_image.length - 1 - i];
            m_image[m_image.length - 1 - i] = temp;
        }
    }
}
