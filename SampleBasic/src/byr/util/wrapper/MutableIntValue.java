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

    public MutableIntValue setValue(int value) {
        m_value = m_value;
        return this;
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
