package de.hsfd.algods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SparseVektorTest {

    @Test
    void isEmpty() {
        SparseVektor v = new SparseVektor();
        assertTrue(v.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        SparseVektor v = new SparseVektor();
        v.setElement(0, 1);
        assertFalse(v.isEmpty());
    }

    @Test
    void isEnd() {
        SparseVektor v = new SparseVektor();
        assertTrue(v.isEnd());
    }

    @Test
    void testIsNotEnd() {
        SparseVektor v = new SparseVektor();
        v.setElement(0, 1);
        assertFalse(v.isEnd());
    }

    @Test
    void testIsNotEndForAscending() {
        SparseVektor v = new SparseVektor();
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
        SparseVektor v = new SparseVektor();
        for (int i = 10; i >= 0; i--) {
            v.setElement(i, i*2);
        }
        assertEquals(0, v.curr_index());
        assertFalse(v.isEnd());
        System.out.println(v);
    }

    @Test
    void reset() {
        SparseVektor v = new SparseVektor();
        v.setElement(12, 1);
        v.setElement(2, 3);
        v.setElement(10, 2);
        v.setElement(0, 4);
        v.reset();
        assertEquals(0, v.curr_index());
    }

    @Test
    void advance() {
        SparseVektor v = new SparseVektor();
        v.setElement(2, 3);
        v.setElement(1, 2);
        v.setElement(0, 1);
        v.advance();
        assertEquals(1, v.curr_index());
    }

    @Test
    void curr_data() {
        SparseVektor v = new SparseVektor();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(2, 3);
        assertEquals(3.0, v.curr_data()); // this means the current pointer is at a node with index 1
    }

    @Test
    void curr_index() {
        SparseVektor v = new SparseVektor();
        v.setElement(1, 1);
        v.setElement(2, 2);
        v.setElement(30, 3);
        assertEquals(30, v.curr_index()); // this means the current pointer is at a node with index 2
    }

    @Test
    void updateCurrData() {
        SparseVektor v = new SparseVektor();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(2, 3);
        v.updateCurrData(10);
        assertEquals(2, v.curr_index());
        assertEquals(10, v.curr_data());
    }

    @Test
    void at() {
        SparseVektor v = new SparseVektor();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(2, 3);
        assertEquals(2.0, v.at(1));
    }

    @Test
    void insert() {
        SparseVektor v = new SparseVektor();
        v.insert(10);
        assertEquals(10, v.at(0));
    }

    @Test
    void testInsertWithPos() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        System.out.println("Before insert 10 with pos 2" + v);
        v.insert(10, 2);
        assertEquals(10, v.at(2));
        System.out.println("v after insert with pos: " + v);

    }

    @Test
    void delete() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        v.delete();
        assertEquals(2.0, v.at(1));
        System.out.println("v after delete: " + v);
    }

    @Test
    void testDeleteNotValid() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        assertThrows(RuntimeException.class, () -> v.delete(4));
    }

    @Test
    void find() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);

        assertTrue(v.find(1.0));
    }

    @Test
    void testFindNotValid() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        assertFalse(v.find(10));
    }

    @Test
    void setElement() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        assertEquals(1.0, v.at(7));
    }

    @Test
    void getElement() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        assertEquals(1.0, v.getElement(7));
    }

    @Test
    void testGetElementNotValid() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        assertEquals(0.0, v.getElement(10));
    }

    @Test
    void removeElement() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        v.removeElement(1);
        assertThrows(RuntimeException.class, () -> v.at(1));
    }

    @Test
    void getLength() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        assertEquals(3, v.getLength());
    }

    @Test
    void testEquals() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVektor v2 = new SparseVektor();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(27, 3);
        assertTrue(v.equals(v2));
    }

    @Test
    void testNotEqualsIndex() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVektor v2 = new SparseVektor();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(27, 4);
        assertFalse(v.equals(v2));
    }

    @Test
    void testNotEqualsLength() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVektor v2 = new SparseVektor();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        assertFalse(v.equals(v2));
    }

    @Test
    void testNotEqualsData() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVektor v2 = new SparseVektor();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(27, 4);
        assertFalse(v.equals(v2));
    }

    @Test
    void add() {
        SparseVektor v = new SparseVektor();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVektor v2 = new SparseVektor();
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
        SparseVektor v1 = new SparseVektor();
        v1.setElement(1, 2);
        v1.setElement(3, 4);

        SparseVektor v2 = new SparseVektor();
        v2.setElement(1, 1);

        v1.add(v2);

        assertEquals(3.0, v1.getElement(1));
        assertEquals(4.0, v1.getElement(3));
    }

    @Test
    void testaddVektorGreaterThanThis() {
        SparseVektor v1 = new SparseVektor();
        v1.setElement(1, 2);

        SparseVektor v2 = new SparseVektor();
        v2.setElement(1, 1);
        v2.setElement(3, 4);

        v1.add(v2);

        assertEquals(3.0, v1.getElement(1));
        assertEquals(4.0, v1.getElement(3));
    }

    @Test
    void testaddVektorEqualThis() {
        SparseVektor v1 = new SparseVektor();
        v1.setElement(1, 2);
        v1.setElement(3, 4);

        SparseVektor v2 = new SparseVektor();
        v2.setElement(1, 1);
        v2.setElement(3, 4);

        v1.add(v2);

        assertEquals(3.0, v1.getElement(1));
        assertEquals(8.0, v1.getElement(3));
    }
}