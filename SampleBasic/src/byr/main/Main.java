/*----------------------------------------------------------------------------------------------------------------------
    izlence(oop): 50.
----------------------------------------------------------------------------------------------------------------------*/
package byr.main;


import byr.util.collection.CSDArrayList;

class Main {
    public static void main(String[] args)
    {
        CSDArrayList numbers = new CSDArrayList();

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        for (int i = 0; i < 15; ++i)
            numbers.add(i * 10);

        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());

        int size = numbers.size();

        for (int i = 0; i < size; ++i) {
            int val = (int)numbers.get(i);

            System.out.printf("%d ", val);
        }

        System.out.println();
        numbers.clear();
        System.out.printf("Capacity:%d%n", numbers.capacity());
        System.out.printf("Size:%d%n", numbers.size());
    }
}