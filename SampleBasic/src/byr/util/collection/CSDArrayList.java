/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList Sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package byr.util.collection;

public class CSDArrayList {
    private Object [] m_elems;

    private int m_capacity;
    private int m_index;

    private void IndexOutOfBoundException(String message)
    {
        System.out.println(message);
        System.exit(1);
    }
    private void WrongValueOfCapacityException(String message)
    {
        System.out.println(message);
        System.exit(1);
    }

    private void checkCapacity(int capacity) {
        if (capacity < 0)
            WrongValueOfCapacityException("wrong value of capacity Exception");
    }

    private void enlargeCapacity()
    {
        if (m_index == m_capacity)
            setCapacity(m_capacity == 0 ? 1 : m_capacity * 2);
    }

    private void setCapacity(int capacity)
    {
        Object [] temp = new Object[capacity];
        m_capacity = capacity;

        System.arraycopy(m_elems, 0,temp, 0, m_index);

        m_elems = temp;
    }

    private void checkIndex(int index)
    {
        if (index < 0 || index >= m_index)
            IndexOutOfBoundException("Index out of bound exception");
    }
    public CSDArrayList()
    {
        this(10);
    }

    public CSDArrayList(int capacity)
    {
        checkCapacity(capacity);
        m_elems = new Object[capacity];
        m_capacity = capacity;
    }

    public void add(Object object)
    {
        enlargeCapacity();
        m_elems[m_index++] = object;
    }

    public void add(int index, Object object)
    {
        // todo:
    }
    public int capacity()
    {
        return m_capacity;
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int newCapacity)
    {
        checkCapacity(newCapacity);

        if (m_capacity >= newCapacity)
            return;

        setCapacity(Math.max(m_capacity * 2, newCapacity));

    }

    public Object get(int index)
    {
        checkIndex(index);

        return m_elems[index];
    }

    public int size()
    {
        return m_index;
    }

    public void trimToSize()
    {
        if (m_capacity == m_index)
            return;

        setCapacity(m_index);
    }

    //...
}
