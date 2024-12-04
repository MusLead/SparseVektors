package de.hsfd.algods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * This test is using a framework from junit jupiter API
 * To execute this test, please use gradle builder 
 * and set dependencies for these test
 * 
 * build.gradle:
 * dependencies {
 * testImplementation platform('org.junit:junit-bom:5.10.0')
 * testImplementation 'org.junit.jupiter:junit-jupiter'
 * }
 */

class CheckSparseVector {

    @Test //Ahmedou
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

    @Test //Ahmedou
    void testSetElementNegativeIndex() {
        SparseVector v = new SparseVector(10);
        assertThrows(RuntimeException.class, () -> v.setElement(-1, 10), "Negative index should throw an exception");
    }

    @Test //Ahmmedou 
    void testSetElementWithValueZero() {
        SparseVector v = new SparseVector(5);
        v.setElement(2, 0); // Keine Ausnahme, aber Element sollte nicht hinzugefügt werden
        assertEquals(0.0, v.getElement(2), "Value 0 should not be added to the SparseVector, therefore according to the task, the value must be 0");
    }

    @Test //Ahmedou
    void testEqualsIdenticalVectors() {
        SparseVector v1 = new SparseVector();
        SparseVector v2 = new SparseVector();
        v1.setElement(1, 5);
        v2.setElement(1, 5);
        assertTrue(v1.equals(v2), "Two identical vectors should be equal");
    }

    @Test //Ahmedou
    void testNotEqualsDifferentVectors() {
        SparseVector v1 = new SparseVector();
        SparseVector v2 = new SparseVector();
        v1.setElement(1, 5);
        v2.setElement(1, 6);
        assertFalse(v1.equals(v2), "Two different vectors should not be equal");
    }

    @Test //Ahmedou
    void testAddTwoVectors() {
        SparseVector v1 = new SparseVector();
        SparseVector v2 = new SparseVector();
        v1.setElement(1, 5);
        v2.setElement(1, 10);

        v1.add(v2);

        assertEquals(15.0, v1.getElement(1), "Values at index 1 should be summed up");
    }

    @Test //Ahmedou
    void testResetVector() {
        SparseVector v = new SparseVector();
        v.setElement(1, 5);
        v.setElement(2, 10);

        v.reset();

        assertEquals(2, v.getLength(), "even with reset, there should be 2 elements within the list.");
    }

    @Test //Ahmedou
    void testExceedMaxSize() {
        SparseVector v = new SparseVector(2);
        v.setElement(1, 5);
        v.setElement(2, 10);
        assertThrows(RuntimeException.class, () -> v.setElement(3, 15), "Exceeding max size should throw an exception");
    }

    @Test //Ahmedou
    void testRemoveAndReAddElement() {
        SparseVector v = new SparseVector(5);
        v.setElement(1, 10);
        v.removeElement(1);
        assertThrows(RuntimeException.class, () -> v.at(1), "Removed element should not be accessible");
        v.setElement(1, 20);
        assertEquals(20.0, v.getElement(1), "Re-added element should be accessible");
    }

    @Test //Agha
    void atIndexOutOfBoud(){
        SparseVector v = new SparseVector();
        for(int i = 0; i< 10; i++) v.setElement(i, i*2 + 15);
        assertThrows(IndexOutOfBoundsException.class, () -> v.at(12));
    }

    @Test //Jack
    void TestCountEqualsLength(){
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
            assertEquals("Vector is full", e.getMessage(), "adding another element is prohibited");
        }
    }

    @Test //Jack
    void TestRemoveThanZero(){
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
            assertEquals("Vector is empty", e.getMessage(), "remove element more that the given length is prohibited");
        } 
    }

    @Test //Jack TODO check again the test implementation 
    void testConstructorWithLimitN(){
        SparseVector v = new SparseVector(3);
        try {
            v.setElement(0, 20);
            v.setElement(1, 10);
            v.setElement(2, 10);
        } catch (RuntimeException e) {

            assertEquals("Value of the Element is zero",  e.getMessage());
            assertThrows(RuntimeException.class, () -> v.at(1));
        }
        
    }
    
    @Test //Agha TODO check again the test implementation 
    void testAddElementWithValueZero(){
        SparseVector v = new SparseVector();
        v.setElement(0,10);
        v.setElement(1, 0);
        assertEquals(1, v.getLength(),"there should only be one element, since the element with value 0 is being ignored.");
    }

    @Test //Agha
    void isEnd() {
        SparseVector v = new SparseVector();
        assertTrue(v.isEnd());
    }

    @Test //Agha
    void testIsNotEnd() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        assertFalse(v.isEnd());
    }

    @Test //Agha
    void testIsNotEndForAscending() {
        SparseVector v = new SparseVector();
        for (int i = 0; i < 10; i++) {
            v.setElement(i, i*2);
        }
        assertEquals(9, v.curr_index(), "this means the current pointer is at a node with index 8"); 
        assertFalse(v.isEnd());
        System.out.println(v);
    }

    @Test //Agha
    void testIsNotEndForDescending() {
        SparseVector v = new SparseVector();
        for (int i = 10; i >= 0; i--) {
            v.setElement(i, i*2);
        }
        assertEquals(1, v.curr_index());
        assertFalse(v.isEnd());
        System.out.println(v);
    }

    @Test //Agha
    void reset() {
        SparseVector v = new SparseVector();
        v.setElement(12, 1);
        v.setElement(2, 3);
        v.setElement(10, 2);
        v.setElement(0, 4);
        v.reset();
        assertEquals(0, v.curr_index());
    }

    @Test //Agha
    void advance() {
        SparseVector v = new SparseVector();
        v.setElement(2, 3);
        v.setElement(1, 2);
        v.setElement(0, 1);
        v.advance();
        assertEquals(1, v.curr_index());
    }

    @Test //Agha
    void updateCurrData() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(2, 3);
        v.updateCurrData(10.0);
        assertEquals(2, v.curr_index());
        assertEquals(10, v.curr_data());
    }

    @Test //Agha
    void setElement() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        assertEquals(1.0, v.at(7));
    }

    @Test //Agha
    void getElement() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        assertEquals(1.0, v.getElement(7));
    }

    @Test //Agha
    void testGetElementNotValid() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        assertEquals(0.0, v.getElement(10));
    }

    @Test //Agha
    void removeElement() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        v.removeElement(1);
        assertThrows(RuntimeException.class, () -> v.at(1));
    }

    @Test //Saba
    void removeAnElementTwoTimes() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.removeElement(0);
        assertThrows(RuntimeException.class, () -> v.removeElement(0));
    }

    @Test //Agha
    void getLength() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        assertEquals(3, v.getLength());
    }

    @Test //Agha
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

    @Test //Agha
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

    @Test //Agha
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

    @Test //Agha
    void testNotEqualsData() {
        SparseVector v = new SparseVector();
        v.setElement(7, 1);
        v.setElement(1, 2);
        v.setElement(27, 3);
        SparseVector v2 = new SparseVector();
        v2.setElement(7, 1);
        v2.setElement(1, 2);
        v2.setElement(27, 4);
        assertFalse(v.equals(v2),"since the index 27 have diffrent values from both of the vectors");
    }

    @Test //Agha
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
        assertThrows(RuntimeException.class, () -> v.at(2), "there is no element with index 2");
        assertEquals(2.0, v.at(7));
        assertEquals(3.0, v.at(27));
        assertEquals(4.0, v.at(28));
    }

    @Test //Agha
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

    @Test //Agha
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

    @Test //Agha
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

    @Test //Agha
    void checkAddifEndSameIndex() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.setElement(9, 3);
        SparseVector v2 = new SparseVector();
        v2.setElement(0, 1);
        v2.setElement(7, 2);
        v2.setElement(9, 40);
        v.add(v2);
        System.out.println(v);
        assertEquals(43.0, v.at(9), "at the end of the element, add two elements beacuse of the same index");
    }

    @Test //Saba
    void testAddTwoEmptyVectors() {
        SparseVector v1 = new SparseVector();
        SparseVector v2 = new SparseVector();
        v1.add(v2);
        assertEquals(0, v1.getLength());
    }

    @Test //Saba
    void setElementsAfterReset() {
        SparseVector v = new SparseVector();
        v.setElement(0, 1);
        v.setElement(1, 2);
        v.reset();
        v.setElement(2, 3);
        assertEquals(1, v.getElement(0));
        assertEquals(2, v.getElement(1));
        assertEquals(3, v.getElement(2));
    }

    @Test //Saba
    void testHandleLargeVector() {
        SparseVector v = new SparseVector();
        v.setElement(1000000, 1);
        assertEquals(1., v.getElement(1000000));
    }

}