package de.hsfd.algods;

public class SparseVektor extends AlgoDS_LinkedList {

    SparseVektor() {
        super();
    }

    SparseVektor(int size) {
        super();
        //TODO: is this correct the implementation of the length of the vector?
        for (int i = 0; i < size; i++) {
            setElement(i, 0);
        }
    }

    /**
     * Insert the element at the index of this vector
     * If the index is greater than the length of the vector, the element will be inserted at the end of the vector
     * If the index is less than the length of the vector, the element will be inserted at the index
     * @param value the value of the element to insert
     * @param index the index of the element to insert
     */
    public void setElement(int index, double value) throws RuntimeException {
        this.insert(value, index);
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
            return (double) this.at(index);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Remove the element at the index
     * @param index the index of the element to remove
     */
    public void removeElement(int index) {
        this.delete(index);
    }

    /**
     * Get the length of this vector.
     * Reset this vector current pointer, then iterate through the vector and count the length
     * @return the length of this vector
     */
    public int getLength() {
        this.reset();
        int length = 0;
        while (!this.isEnd()) {
            length++;
            this.advance();
        }
        return length;
    }

    /**
     * Check if the two vectors are equal
     * First check if the length of the two vectors are equal
     * Then check if the data and index of the two vectors are equal
     * If all the conditions are met, return true
     * @param v the other vector to compare with
     * @return true if the two vectors are equal, false otherwise
     */
    public boolean equals(SparseVektor v) {
        // check if the two vectors are equal
        if (this.getLength() != v.getLength()) {
            return false;
        }
        this.reset();
        v.reset();
        while (!this.isEnd()) {
            if ((double) this.curr_data() != (double) v.curr_data()) {
                return false;
            }
            if (this.curr_index() != v.curr_index()) {
                return false;
            }
            this.advance();
            v.advance();
        }
        return true;
    }

    /**
     * Combine the two vectors this and v.
     * This vector will be the result of the addition of the two vectors.
     * If the index of the two vectors are equal, the data of the two vectors will be added into this vector
     * If the index of the two vectors are not equal, the data of the vector v will be inserted into this vector
     * @param v the other vector to add to this vector
     */
    public void add(SparseVektor v) {
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
                            this.updateCurrData((double) this.curr_data() + (double) v.curr_data());
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
