package byr.samples.application.parser;

public class StringSource implements ISource{
    private final String m_str;
    private int m_idx;

    public StringSource(String str)
    {
        m_str = str;
    }
    public int nextChar()
    {
        return m_str.length() == m_idx ? -1 :  m_str.charAt(m_idx++);
    }

    public void reset()
    {
        m_idx = 0;
    }
    //...
}
