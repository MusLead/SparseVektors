package de.hsfd.algods;


/**
 * A linked list implementation of the AlgoDS_List interface
 * This class implements the AlgoDS_List interface and provides
 * the basic operations of a linked list
 * <p>
 *
 * There are two pointers in this class: <p>
 * 1. begin: a pointer to the beginning of the list <p>
 * 2. current: a pointer to the current element in the list <p>
 * Current is always pointing to the element before the next element.
 * That means by default, current is pointing to the beginning of the list
 * that does not represent any element.
 */
public class AlgoDS_LinkedList implements AlgoDS_List {

    private final AlgoDS_Node begin;
    private AlgoDS_Node current_pointer;

    /**
     * Initialize the begin and current pointers
     * The begin and current pointer is pointing to the beginning of the list
     * As you see the begin and current pointers are *sharing* the same node
     * that means if the current.next is updated, the begin.next is also updated
     */
    AlgoDS_LinkedList() {
        begin = current_pointer = new AlgoDS_Node(null, 0, null);
    }

    /**
     * Check if the list is empty by checking if the next element of the begin pointer is null
     * @return true if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return begin.getNext() == null;
    }

    /**
     * Check if the current pointer is at the end of the list <p>
     * WARNING: This function does not represent the current element, instead
     * it represents the current pointer that lies before the current element
     * @return true if the current pointer is at the end of the list
     */
    @Override
    public boolean isEnd() {
        // DO NOT CALL current() function here
        // It will recursively call the isEnd() function!
        return current_pointer.getNext() == null;
    }

    /**
     * Reset the current pointer to the beginning of the list
     */
    @Override
    public void reset() {
        current_pointer = begin;
    }

    /**
     * Move the current pointer to the next element
     * If the current pointer is at the end of the list, throw an exception
     */
    @Override
    public void advance() {
        if (isEnd()) throw new RuntimeException("No next element");
        current_pointer = current();
    }

    /**
     * Get the current element (that is the element after the current pointer)
     * If the current pointer is at the end of the list, throw an exception.<p>
     * WARNING: With this function, you can get the current element and update the element,
     * but you can not update the current pointer!
     * @return the current element
     */
    @Override
    public AlgoDS_Node current() {
        if (isEnd()) throw new RuntimeException("No current element");
        return current_pointer.getNext();
    }

    /**
     * Get the data of the current element
     * If the current pointer is at the end of the list, throw an exception.<p>
     * WARNING: This function just return the data of the current element,
     * it does not able to update the data of the current element
     * @return the data of the current element
     */
    public Object curr_data() {
        if (isEnd()) throw new RuntimeException("No current element");
        return current().getData();
    }

    /**
     * Get the index of the current element (it means that the current pointer lies before the current element).
     * If the current pointer is at the end of the list, throw an exception.<P>
     * WARNING: This function just return the index of the current element,
     * it does not able to update the index of the current element
     * @return the index of the current element
     */
    public int curr_index(){
        return current().getIndex();
    }

    /**
     * Update the current element with the new data
     * If the current pointer is at the end of the list, throw an exception.
     * @param data the new data to update the current element
     */
    public void updateCurrData(Object data){
        if (isEnd()) throw new RuntimeException("No current element");
        current().setData(data);
    }

    /**
     * Get the element at the index position in the list
     * reset the current pointer and iterate through the list until the index is found
     * if the index is not found or the requested index is invalid, throw an exception
     * @param index the new index to update the current element
     */
    @Override
    public Object at(int index) {
        if(index < 0) throw new RuntimeException("Invalid index");
        reset();
        while (!isEnd() && curr_index() != index) {
            if (isEnd()) throw new RuntimeException("Index is not found");
            advance();
        }
        return curr_data();
    }

    /**
     * Insert the element at the current position
     * The new element will be inserted after the current pointer
     * The current_pointer.next will be updated to the new element
     * @param x the element to insert
     */
    @Override
    public void insert(Object x) {
        AlgoDS_Node newNode = new AlgoDS_Node(x, 0, null);
        try {
            newNode.setNext(current());
        } catch (RuntimeException e) {
            newNode.setNext(null);
        }
        current_pointer.setNext(newNode);
    }

    /**
     * Insert the element at the position.
     * Reset the current pointer and iterate
     * through the list until the position in the right position and insert the element.
     * If the position is not found or the
     * requested position is invalid, throw an exception
     * @param x the element to insert
     * @param pos the position to insert the element
     */
    @Override
    public void insert(Object x, int pos) {
        if (pos < 0) throw new RuntimeException("Invalid position");
        reset();
        while (!isEnd() && curr_index() < pos)
            advance();
        // the pos must be less and equal to the current index to be able to insert
        insert(x);
        current().setIndex(pos);
    }

    /**
     * Delete the element at the current position.
     * If the current position is the end of the list, throw an exception
     */
    @Override
    public void delete() {
        if (isEnd()) throw new RuntimeException("No element to delete");
        current_pointer.setNext(current().getNext());
    }

    /**
     * Delete the element at the position.
     * Reset the current pointer and iterate
     * through the list until the position is found and delete the element
     * if the position is not found or the
     * requested position is invalid, throw an exception
     * @param pos the position of the element to delete
     */
    @Override
    public void delete(int pos) {
        if (pos < 0) throw new RuntimeException("Invalid position");
        reset();
        while(!isEnd() && curr_index() != pos){
            advance();
        }
        if(isEnd()) throw new RuntimeException("Invalid position");
        delete();
    }

    /**
     * Search for the element in the list
     * Reset the current pointer and iterate
     * through the list until the element is found.
     * If the element is found, return true, otherwise return false
     * @param value the element to find
     * @return true if the element is found, false otherwise
     */
    @Override
    public boolean find(Object value) {
        reset();
        while (!isEnd() && !curr_data().equals(value)) {
            advance();
        }
        return !isEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        reset();
        while (!isEnd()) {
            sb.append(curr_data()).append(" ");
            advance();
        }
        reset();
        return sb.toString();
    }
}
