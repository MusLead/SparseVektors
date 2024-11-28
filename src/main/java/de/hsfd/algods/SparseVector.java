package de.hsfd.algods;

class Node {
    private Double data;
    private int index;
    private Node next;

    Node(Double data, int index) {
        this.data = data;
        this.index = index;
        this.next = null;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public Double getData() {
        return data;
    }
    
    public int getIndex() {
        return index;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {

    public final Node begin;
    public Node current_pointer;

    LinkedList() {
        this.begin = this.current_pointer = new Node(null, -1);
        this.current_pointer.setNext(null);
    }

     /**
     * Insert the element at the current position
     * The new element will be inserted after the current pointer
     * The current_pointer.next will be updated to the new element
     * @param x the element to insert
     */
    protected void insert(Double x, int index) {
        Node newNode = new Node(x, index);
        try {
            newNode.setNext(this.current());
        } catch (RuntimeException e) {
            newNode.setNext(null);
        }
        current_pointer.setNext(newNode);
    }

    /**
     * Get the current element (that is the element after the current pointer)
     * If the current pointer is at the end of the list, throw an exception.<p>
     * WARNING: With this function, you can get the current element and update the element,
     * but you can not update the current pointer!
     * @return the current element
     */
    protected Node current() {
        if (isEnd()) throw new RuntimeException("No current element");
        return current_pointer.getNext();
    }

    /**
     * Check if the current pointer is at the end of the list. In other word, there is no elemnt left after the current pointer <p>
     * WARNING: This function does not represent the current element, instead
     * it represents the current pointer that lies before the current element
     * @return true if the current pointer is at the end of the list. 
     */
    protected boolean isEnd() {
        // DO NOT CALL current() FUNCTION HERE!
        // It will recursively call the isEnd() function!
        return current_pointer.getNext() == null;
    }

    /**
     * Reset the current pointer to the beginning of the list
     */
    protected void reset() {
        current_pointer = begin;
    }

    /**
     * Get the index of the current element (it means that the current pointer lies before the current element).
     * If the current pointer is at the end of the list, throw an exception.<P>
     * WARNING: This function just return the index of the current element,
     * it does not able to update the index of the current element
     * @return the index of the current element
     */
    protected int curr_index(){
        return current().getIndex();
    }

    /**
     * Get the data of the current element
     * If the current pointer is at the end of the list, throw an exception.<p>
     * WARNING: This function just return the data of the current element,
     * it does not able to update the data of the current element
     * @return the data of the current element
     */
    protected Double curr_data() {
        if (isEnd()) throw new RuntimeException("No current element");
        return current().getData();
    }

    /**
     * Get the element at the index position in the list
     * reset the current pointer and iterate through the list until the index is found
     * if the index is not found or the requested index is invalid, throw an exception
     * @param index the new index to update the current element
     */
    protected Double at(int index) {
        if(index < 0) throw new RuntimeException("Invalid index");
        reset();
        while (!isEnd() && curr_index() != index) {
            if (isEnd()) throw new RuntimeException("Index is not found");
            advance();
        }
        return curr_data();
    }

    /**
     * Move the current pointer to the next element
     * If the current pointer is at the end of the list, throw an exception
     */
    protected void advance() {
        if (isEnd()) throw new RuntimeException("No next element");
        current_pointer = current();
    }

    /**
     * Delete the element at the position.
     * Reset the current pointer and iterate
     * through the list until the position is found and delete the element
     * if the position is not found or the
     * requested position is invalid, throw an exception
     * @param pos the position of the element to delete
     */
    protected void delete(int pos) {
        if (pos < 0) throw new RuntimeException("Invalid position");
        reset();
        while(!isEnd() && curr_index() != pos){
            advance();
        }
        if(isEnd()) throw new RuntimeException("No elements to be removed");
        delete();
    }

    /**
     * Delete the element at the current position.
     * If the current position is the end of the list, throw an exception
     */
    protected void delete() {
        if (isEnd()) throw new RuntimeException("No element to delete");
        current_pointer.setNext(current().getNext());
    }

}

public class SparseVector extends LinkedList {
    
    private int sizeMax = -1;
    private int count = 0;

    SparseVector() {
        super();
    }

    SparseVector(int size) {
        super();
        if (size < 1) throw new RuntimeException("Invalid size");
        this.sizeMax = size;
    }

    /**
     * Insert the element at the index of this vector
     * If the index is greater than the length of the vector, the element will be inserted at the end of the vector
     * If the index is less than the length of the vector, the element will be inserted at the index
     * @param value the value of the element to insert
     * @param index the index of the element to insert
     */
    public void setElement(int index, double value) throws RuntimeException {
        if(sizeMax != -1)
            if(count++ >= sizeMax) throw new RuntimeException("Vector is full");
        if (index < 0) throw new RuntimeException("Invalid position");
        reset();
        while (!isEnd() && curr_index() < index)
            advance();
        if (value != 0){
            this.insert(value, index);
        }
        else {
            System.out.println("valeu is 0, it can't add the element");
        }
    }

    /**
     * Get the element at the index of this vector
     * using at function from AlgoDS_LinkedList
     * @param index the index of the element to get
     * @return the element at the index
     */
    public double getElement(int index) {
        // return the value of the index
        try {
            return this.at(index);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Remove the element at the index
     * @param index the index of the element to remove
     */
    public void removeElement(int index) {
        if(sizeMax != -1)
            if(count-- <= 0) throw new RuntimeException("Vector is empty");
        this.delete(index);
    }

    /**
     * Get the length of this vector.
     * Reset this vector current pointer, then iterate through the vector and count the length
     * @return the length of this vector
     */
    public int getLength() {
        if (this.sizeMax != -1) return count;
        this.reset();
        int totalElements = 0;
        while (!this.isEnd()) {
            totalElements++;
            this.advance();
        }
        return totalElements;
    }

    /**
     * Check if the two vectors are equal
     * First check if the length of the two vectors are equal
     * Then check if the data and index of the two vectors are equal
     * If all the conditions are met, return true
     * @param v the other vector to compare with
     * @return true if the two vectors are equal, false otherwise
     */
    public boolean equals(SparseVector v) {
        // check if the two vectors are equal
        if (this.getLength() != v.getLength()) {
            return false;
        }
        this.reset();
        v.reset();
        while (!this.isEnd()) {
            if (!this.curr_data().equals(v.curr_data()) | 
                this.curr_index() != v.curr_index()) 
                return false;
            this.advance();
            v.advance();
        }
        return true;
    }

    /**
     * Update the current element with the new data
     * If the current pointer is at the end of the list, throw an exception.
     * @param data the new data to update the current element
     */
    protected void updateCurrData(Double data){
        if (isEnd()) throw new RuntimeException("No current element");
        current().setData(data);
    }

    /**
     * Combine the two vectors this and v.
     * This vector will be the result of the addition of the two vectors.
     * If the index of the two vectors are equal, the data of the two vectors will be added into this vector
     * If the index of the two vectors are not equal, the data of the vector v will be inserted into this vector
     * @param v the other vector to add to this vector
     */
    public void add(SparseVector v) {
        // add the two vectors
        this.reset();
        v.reset();
        while (!v.isEnd()) {
            if (this.isEnd()) {
                this.insert(v.curr_data(),v.curr_index());
            } else {
                try {
                    if (this.curr_index() <= v.curr_index()) {
                        if (this.curr_index() < v.curr_index())
                            advance();
                        if (this.isEnd()) {
                            this.insert(v.curr_data(), v.curr_index());
                        } else if (this.curr_index() == v.curr_index())
                            this.updateCurrData(this.curr_data() + v.curr_data());
                        else continue;
                    } else this.insert(v.curr_data(), v.curr_index());
                } catch (Exception e) {
                    System.err.println(e.getMessage() + (this.isEnd() ? ", vektor: this" : ", vektor: v"));
                    System.err.println("current > this: " + (!this.isEnd() ? this.current() : "null") + ", v: " + (!v.isEnd() ? v.current() : "null"));
                    System.err.println("this: " + this + "\nv: " + v);
                    throw e;
                }
            }
            v.advance();
        }
    }


    @Override
    public String toString() {
        this.reset();
        StringBuilder sb = new StringBuilder();
        while (!this.isEnd()) {
            sb.append("(v:").append(this.curr_data()).append(", i:").append(this.curr_index()).append("), ");
            this.advance();
        }
        this.reset();
        return sb.toString();
    }

}
