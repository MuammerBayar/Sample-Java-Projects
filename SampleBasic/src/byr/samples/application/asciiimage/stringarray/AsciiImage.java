package byr.samples.application.asciiimage.stringarray;

public class AsciiImage {
    private String [] m_image;


    public AsciiImage(String [] img)
    {
        m_image = img;
    }

    public void transpose()
    {
        char [][] chars = new char[m_image.length][];

        for (int i = 0; i < chars.length; ++i)
            chars[i] = m_image[i].toCharArray();

        char [][] result = new char[m_image[0].length()][m_image.length];
        String [] newImg = new String[result.length];

        for (int i = 0; i < result.length ; ++i) {
            for (int k = 0; k < chars.length; ++k)
                result[i][k] = chars[k][result.length - 1 - i];

            newImg[i] = String.valueOf(result[i]);
        }

        m_image = newImg;
    }
    public void disp()
    {
        for (String s : m_image)
            System.out.println(s);

        System.out.printf("%d %d%n", m_image[0].length(), m_image.length);
    }

    public void flipv()
    {
        for (int i = 0; i < m_image.length / 2; ++i) {
            String temp = m_image[i];
            m_image[i] = m_image[m_image.length - 1 - i];
            m_image[m_image.length - 1 - i] = temp;
        }
    }
}
