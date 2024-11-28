package de.hsfd.algods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            
            SparseVector v = new SparseVector();
            
            v.setElement(700, 1);
            v.setElement(31, 223);
            v.setElement(70, 342);
            v.setElement(1, 4);
            v.setElement(4, 37);
            System.out.println("Vector v: " + v);

            SparseVector v2 = new SparseVector();
            v2.setElement(7, 1);
            v2.setElement(3, 223);
            v2.setElement(5, 342);
            v2.setElement(4, 37);
            v2.setElement(1, 4);
            System.out.println("Vector v2: " + v2);

            v.add(v2);
            System.out.println("Vector v: " + v);

            v.removeElement(4);

            System.out.println("Vector v: " + v);
            System.out.println("element at index 7: " + v.getElement(7));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
        