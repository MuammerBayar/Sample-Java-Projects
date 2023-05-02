/*----------------------------------------------------------------------------------------------------------------------
    Fraction sınıfı
    todo:
----------------------------------------------------------------------------------------------------------------------*/
package byr.util.math;

public class Fraction {
    private int m_a;
    private int m_b;

    private void check(int a, int b)
    {
        if(b == 0)
            if (a == 0) {
                System.out.println("undefined");
                System.exit(0);
            }
            else {
            System.out.println("infinite");
            System.exit(0);
        }

    }

    private void sign(int a, int b)
    {
        if (b < 0) {
            a = -a;
            b = -b;
        }
        m_a = a;
        m_b = b;
    }

    private void simplify()
    {
        int min = Math.min(Math.abs(m_a),m_b);

        for(int i = 2; i <= min; ++i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
            }
    }

    private void set(int a, int b)
    {
        if (a == 0) {
            m_b = 1;
            return;
        }

        check(a,b);
        sign(a,b);
        simplify();
    }

    public Fraction(int a, int b)
    {
        set(a,b);
    }

    public Fraction(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public String toString()
    {
        return String.format(m_a == 0 || m_b == 1 ? "%d " : " %d / " + m_b,m_a);
    }

}
