/*----------------------------------------------------------------------------------------------------------------------
    Circle Sınıfı
    last update:16.04.2023
----------------------------------------------------------------------------------------------------------------------*/
package byr.util.math.geometry;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Circle {
    private double m_r;

    public Circle()
    {
    }

    public Circle(double r)
    {
        this.setRadius(r);
    }

    public double getRadius()
    {
        return m_r;
    }

    public void setRadius(double r)
    {
        m_r = abs(r);
    }

    public double getArea()
    {
        return PI * m_r * m_r;
    }

    public double getCircumference()
    {
        return 2 * PI * m_r;
    }
}
