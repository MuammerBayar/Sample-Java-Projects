package byr.util.wrapper;

public class MutableIntValue {
    private int m_value;

    public MutableIntValue()
    {
    }

    public MutableIntValue(int val)
    {
        m_value = val;
    }

    public int getValue() {
        return m_value;
    }

    public void setValue(int m_value) {
        this.m_value = m_value;
    }

    public MutableIntValue add(int val)
    {
        m_value += val;

        return this;
    }

    public MutableIntValue subtract(int val)
    {
        return this.add(-val);
    }

    public MutableIntValue multiply(int val)
    {
        m_value *= val;

        return this;
    }

    public MutableIntValue divide(int val)
    {
        m_value /= val;

        return this;
    }

    //...
}
