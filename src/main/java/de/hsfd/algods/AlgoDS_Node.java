package de.hsfd.algods;

public class AlgoDS_Node {
    private Object data;
    private int index;
    private AlgoDS_Node next;

    public AlgoDS_Node(Object data, int index, AlgoDS_Node next) {
        this.data = data;
        this.index = index;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }

    public AlgoDS_Node getNext() {
        return next;
    }

    protected void setNext(AlgoDS_Node next) {
        this.next = next;
    }

    protected void setData(Object data) {
        this.data = data;
    }

    protected void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", index=" + index +
                '}';
    }
}
