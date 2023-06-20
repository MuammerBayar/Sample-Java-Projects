package byr.samples.application.parser;

public class CharArraySource implements ISource {
    private final char [] m_chars;
    private int m_idx;

    public CharArraySource(char [] chars)
    {
        m_chars = chars;
    }

    public CharArraySource(String str)
    {
        this(str.toCharArray());
    }

    public int nextChar()
    {
        return m_chars[m_idx++];
    }

    public void reset()
    {
        m_idx = 0;
    }
}
