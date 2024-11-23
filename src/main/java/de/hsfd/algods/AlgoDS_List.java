package de.hsfd.algods;

public interface AlgoDS_List {
    public boolean isEmpty();
    public boolean isEnd();
    public void reset();
    public void advance();
    public Object current();
    public Object at(int index);
    public void insert(Object x);
    public void insert(Object x, int pos);
    public void delete();
    public void delete(int pos);
    public boolean find(Object x);
}
