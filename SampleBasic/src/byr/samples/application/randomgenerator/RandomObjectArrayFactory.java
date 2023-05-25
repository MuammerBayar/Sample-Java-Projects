package byr.samples.application.randomgenerator;

import byr.util.datetime.Date;
import byr.util.math.Fraction;

import java.util.Random;

import static byr.util.array.ArrayUtil.getRandomArray;
import static byr.util.string.StringUtil.getRandomTextTR;

public class RandomObjectArrayFactory {

    private final Random m_random;

    public RandomObjectArrayFactory()
    {
        this(new Random());
    }

    //String, Fraction, Integer, Random, int[], Date, Double, Character, Booelan
    private Object getRandomObject()
    {
        Object object;

        switch (m_random.nextInt(9)) {
            case 0:
                object = getRandomTextTR(m_random.nextInt(9) + 1);
                break;
            case 1:
                object = new Fraction(m_random.nextInt(5) - 5,m_random.nextInt(5) + 1);
                break;
            case 2:
                object = m_random.nextInt(255) - 128;
                break;
            case 3:
                object = new Random();
                break;
            case 4:
                object = getRandomArray(m_random.nextInt(15) + 1, 0, 100);
                break;
            case 5:
                object = new Date();
                break;
            case 6:
                object = m_random.nextDouble();
                break;
            case 7:
                object = (char)(m_random.nextInt(129));
                break;
            default:
                object = m_random.nextBoolean();
        }

        return object;
    }

    private void fillObjects(Object [] objects)
    {
        for (int i = 0; i < objects.length; ++i)
            objects[i] = getRandomObject();
    }

    public RandomObjectArrayFactory(Random random)
    {
        m_random = random;
    }

    public Object [] getObjects(int count)
    {
        Object [] objects = new Object[count];

        fillObjects(objects);

        return objects;
    }
}
