package de.hsfd.algods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AhmedouCheckparseVec {



    @Test
    void testAddIdenticalVectors() {
        SparseVector v1 = new SparseVector();
        v1.setElement(1, 5);
        v1.setElement(2, 10);

        SparseVector v2 = new SparseVector();
        v2.setElement(1, 5);
        v2.setElement(2, 10);

        v1.add(v2);

        assertEquals(10.0, v1.getElement(1));
        assertEquals(20.0, v1.getElement(2));
    }

    @Test
    void testSetElementNegativeIndex() {
        SparseVector v = new SparseVector(10);
        assertThrows(RuntimeException.class, () -> v.setElement(-1, 10), "Negative index should throw an exception");
    }
    @Test
    void testSetElementWithValueZero() {
        SparseVector v = new SparseVector(5);
        v.setElement(2, 0); // Keine Ausnahme, aber Element sollte nicht hinzugefügt werden
        assertEquals(0.0, v.getElement(2), "Value 0 should not be added to the SparseVector");
    }
    @Test
    void testEqualsIdenticalVectors() {
        SparseVector v1 = new SparseVector();
        SparseVector v2 = new SparseVector();
        v1.setElement(1, 5);
        v2.setElement(1, 5);
        assertTrue(v1.equals(v2), "Two identical vectors should be equal");
    }
    @Test
    void testNotEqualsDifferentVectors() {
        SparseVector v1 = new SparseVector();
        SparseVector v2 = new SparseVector();
        v1.setElement(1, 5);
        v2.setElement(1, 6);
        assertFalse(v1.equals(v2), "Two different vectors should not be equal");
    }
    @Test
    void testAddTwoVectors() {
        SparseVector v1 = new SparseVector();
        SparseVector v2 = new SparseVector();
        v1.setElement(1, 5);
        v2.setElement(1, 10);

        v1.add(v2);

        assertEquals(15.0, v1.getElement(1), "Values at index 1 should be summed up");
    }
    @Test
    void testResetVector() {
        SparseVector v = new SparseVector();
        v.setElement(1, 5);
        v.setElement(2, 10);

        v.reset();

        assertEquals(0, v.getLength(), "Vector should be empty after reset");
        assertThrows(RuntimeException.class, () -> v.at(1), "Accessing any element after reset should throw an exception");
    }

    @Test
    void testExceedMaxSize() {
        SparseVector v = new SparseVector(2);
        v.setElement(1, 5);
        v.setElement(2, 10);
        assertThrows(RuntimeException.class, () -> v.setElement(3, 15), "Exceeding max size should throw an exception");
    }
    @Test
    void testRemoveAndReAddElement() {
        SparseVector v = new SparseVector(5);
        v.setElement(1, 10);
        v.removeElement(1);
        assertThrows(RuntimeException.class, () -> v.at(1), "Removed element should not be accessible");
        v.setElement(1, 20);
        assertEquals(20.0, v.getElement(1), "Re-added element should be accessible");
    }
    @Test
    void testSetElementNullValue() {
        SparseVector v = new SparseVector();
        assertThrows(RuntimeException.class, () -> v.setElement(5, null), "Null values should not be allowed");
    }


    @Test
    void testRemoveNonExistentElement() {
        SparseVector v = new SparseVector(5);
        assertThrows(RuntimeException.class, () -> v.removeElement(3), "Removing a non-existent element should throw an exception");
    }






}
