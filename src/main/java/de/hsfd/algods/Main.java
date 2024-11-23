package de.hsfd.algods;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        // implement SparseVektor
        try {
        SparseVektor v = new SparseVektor();
//        for (int i = 0; i < 10; i++) {
//            // setElement randomly
//            v.setElement(i, (int) (Math.random() * 10));
//        }

            v.setElement(700, 1);
            v.setElement(31, 223);
            v.setElement(70, 342);
            v.setElement(1, 4);
            v.setElement(4, 37);
            System.out.println("Vector v: " + v);
            SparseVektor v2 = new SparseVektor();
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
            System.out.println("isEmpty: " + v.isEmpty());

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }
}