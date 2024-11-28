package de.hsfd.algods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CheckSparseVector {
    @Test
    void checkCountEqualsLength(){
        SparseVector v = new SparseVector(7);
        v.setElement(0,2);
        v.setElement(1,2);
        v.setElement(2,4);
        v.setElement(3,3);
        v.setElement(4,5);
        v.setElement(5,10);
        v.setElement(6,12);
        try {
            v.setElement(7, 20);
            
        } catch (RuntimeException e) {
            System.err.print("Implementierung ist richtig: " + e.getMessage());
            assertEquals("Vector is full", e.getMessage());
        }
    }

    @Test
    void removeThanZero(){
        SparseVector v = new SparseVector();
        v.setElement(0,2);
        v.setElement(1,5);
        v.setElement(2,4);

        try {
            for(int i = 0; i < v.getLength() + 3 ; i++){
                v.removeElement(i);
                System.out.println("Removing in index: " + i);
            }
        } catch (RuntimeException e) {
            System.out.print("Implementierung ist richtig: " + e.getMessage());
            assertEquals("Vector is empty", e.getMessage());
        } 
    }

    @Test
    void constructorWithLimitN(){
        SparseVector v1 = new SparseVector(2);
        try {
            v1.setElement(0, 20);
            v1.setElement(1, 10);
            v1.setElement(2, 10);
        } catch (RuntimeException e) {
            System.err.print("Implementierung ist richtig:" + e.getMessage());
            
        }
        
    }


    @Test
    void isEnd() {
        SparseVector v = new SparseVector();
        assertTrue(v.isEnd());
    }

    @Test
    void testIsNotEnd() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        assertFalse(v.isEnd());
    }

    @Test
    void testIsNotEndForAscending() {
        SparseVector v = new SparseVector();
        for (int i = 0; i < 10; i++) {
            v.setElement(i, i*2);
        }
        assertEquals(9, v.curr_index()); // this means the current pointer is at a node with index 8
        assertFalse(v.isEnd());
        System.out.println("With current pointer: " + v.current() + " and current next: " + v.current().getNext());
        System.out.println(v);
    }

    @Test
    void testIsNotEndForDescending() {
        SparseVector v = new SparseVector();
        for (int i = 10; i >= 0; i--) {
            v.setElement(i, i*2);
        }
        assertEquals(0, v.curr_index());
        assertFalse(v.isEnd());
        System.out.println(v);
    }

    @Test
    void reset() {
        SparseVector v = new SparseVector();
        v.setElement(12, 1);
        v.setElement(2, 3);
        v.setElement(10, 2);
        v.setElement(0, 4);
        v.reset();
        assertEquals(0, v.curr_index());
    }

    @Test
    void advance() {
        SparseVector v = new SparseVector();
        v.setElement(2, 3);
        v.setElement(1, 2);
        v.setElement(0, 1);
        v.advance();
        assertEquals(1, v.curr_index());
    }

    @Test
    void curr_data() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(2, 3);
        assertEquals(3.0, v.curr_data()); // this means the current pointer is at a node with index 1
    }

    @Test
    void curr_index() {
        SparseVector v = new SparseVector();
        v.setElement(1, 1);
        v.setElement(2, 2);
        v.setElement(30, 3);
        assertEquals(30, v.curr_index()); // this means the current pointer is at a node with index 2
    }

    @Test
    void updateCurrData() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(2, 3);
        v.updateCurrData(10.0);
        assertEquals(2, v.curr_index());
        assertEquals(10, v.curr_data());
    }

    @Test
    void at() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(2, 3);
        assertEquals(2.0, v.at(1));
    }


    @Test
    void delete() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        v.delete();
        assertEquals(2.0, v.at(1));
        System.out.println("v after delete: " + v);
    }

    @Test
    void testDeleteNotValid() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        assertThrows(RuntimeException.class, () -> v.delete(4));
    }

    @Test
    void setElement() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        assertEquals(1.0, v.at(7));
    }

    @Test
    void getElement() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        assertEquals(1.0, v.getElement(7));
    }

    @Test
    void testGetElementNotValid() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        assertEquals(0.0, v.getElement(10));
    }

    @Test
    void removeElement() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        v.removeElement(1);
        assertThrows(RuntimeException.class, () -> v.at(1));
    }

    @Test
    void getLength() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        assertEquals(3, v.getLength());
    }

    @Test
    void testEquals() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVector v2 = new SparseVector();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(27, 3);
        assertTrue(v.equals(v2));
    }

    @Test
    void testNotEqualsIndex() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVector v2 = new SparseVector();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(27, 4);
        assertFalse(v.equals(v2));
    }

    @Test
    void testNotEqualsLength() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVector v2 = new SparseVector();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        assertFalse(v.equals(v2));
    }

    @Test
    void testNotEqualsData() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVector v2 = new SparseVector();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(27, 4);
        assertFalse(v.equals(v2));
    }

    @Test
    void add() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVector v2 = new SparseVector();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(28, 4);
        v.add(v2);
        assertEquals(4.0, v.at(1));
        assertThrows(RuntimeException.class, () -> v.at(2));
        assertEquals(2.0, v.at(7));
        assertEquals(3.0, v.at(27));
        assertEquals(4.0, v.at(28));
    }

     @Test
    void testaddVektorLessThanThis() {
        SparseVector v1 = new SparseVector();
        v1.setElement(1, 2);
        v1.setElement(3, 4);

        SparseVector v2 = new SparseVector();
        v2.setElement(1, 1);

        v1.add(v2);

        assertEquals(3.0, v1.getElement(1));
        assertEquals(4.0, v1.getElement(3));
    }

    @Test
    void testaddVektorGreaterThanThis() {
        SparseVector v1 = new SparseVector();
        v1.setElement(1, 2);

        SparseVector v2 = new SparseVector();
        v2.setElement(1, 1);
        v2.setElement(3, 4);

        v1.add(v2);

        assertEquals(3.0, v1.getElement(1));
        assertEquals(4.0, v1.getElement(3));
    }

    @Test
    void testaddVektorEqualThis() {
        SparseVector v1 = new SparseVector();
        v1.setElement(1, 2);
        v1.setElement(3, 4);

        SparseVector v2 = new SparseVector();
        v2.setElement(1, 1);
        v2.setElement(3, 4);

        v1.add(v2);

        assertEquals(3.0, v1.getElement(1));
        assertEquals(8.0, v1.getElement(3));
    }
}