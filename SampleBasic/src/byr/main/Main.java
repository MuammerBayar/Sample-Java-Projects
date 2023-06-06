/*----------------------------------------------------------------------------------------------------------------------
    izlence(oop): 51.
----------------------------------------------------------------------------------------------------------------------*/
package byr.main;

import byr.util.collection.CSDArrayList;

class Main {
    public static void main(String[] args)
    {
        CSDArrayList numbers = new CSDArrayList();

        for (int i = 0; i < 10; ++i)
            numbers.add(i * 10);

        System.out.println(numbers);

        numbers.add(5,25);

        System.out.println(numbers);

        numbers.remove(5);

        System.out.println(numbers);

    }
}

