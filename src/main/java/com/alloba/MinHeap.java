package com.alloba;

import java.util.ArrayList;

/**
 *
 * @param <T> Any object type that implements the Comparable interface.
 *
 * An absolutely terrible implementation of a Min Heap. It is inelegant, and the variable names/usage leaves a
 *           lot to be desired, but I have tested it and it does work.
 *           (I only tested on integers and doubles, but es good enuff 4 me)
 */
public class MinHeap<T extends Comparable<? super T>> {
    private ArrayList<T> storage;

    public MinHeap() {
        storage = new ArrayList<>();
    }

    public void insert(T item) {
        storage.add(item);
        int index = storage.size() - 1;
        upHeap(index);
    }

    public T getTop() {
        if(storage.size() == 0) return null;

        T holder = storage.get(0);
        storage.set(0, storage.get(storage.size() - 1));
        storage.set(storage.size() - 1, holder);

        T retVal = storage.remove(storage.size() - 1);

        if(storage.size() != 0)
            downHeap(0);

        return retVal;
    }

    private int getLeftChildIndex(int i) {
        int index = 2 * i + 1;
        if (index >= storage.size()) return -1;
        return index;
    }

    private int getRightChildIndex(int i) {
        int index = 2 * i + 2;
        if (index >= storage.size()) return -1;
        return index;
    }

    private int getParentIndex(int i) {
        int index = (i - 1) / 2;
        if (index < 0 || i == 0) return -1;
        return index;
    }

    private void upHeap(int i) {
        if (getParentIndex(i) == -1)
            return;
        if (storage.get(i).compareTo(storage.get(getParentIndex(i))) >= 0)
            return;

        T holder = storage.get(getParentIndex(i));
        storage.set(getParentIndex(i), storage.get(i));
        storage.set(i, holder);

        upHeap(getParentIndex(i));
    }

    private void downHeap(int i){
        if(getLeftChildIndex(i) == -1 && getRightChildIndex(i) == -1)
            return;

        //the third conditional in this if statement forces the smallest of the two branches to be chosen to shift upwards.
        if(getLeftChildIndex(i)!= -1
                && storage.get(i).compareTo(storage.get(getLeftChildIndex(i))) > 0
                && (getRightChildIndex(i) == -1 || storage.get(getRightChildIndex(i)).compareTo(storage.get(getLeftChildIndex(i))) > 0)
        ){
            T holder = storage.get(getLeftChildIndex(i));
            storage.set(getLeftChildIndex(i), storage.get(i));
            storage.set(i, holder);
            downHeap(getLeftChildIndex(i));
        }
        else if (getRightChildIndex(i)!= -1
                && storage.get(i).compareTo(storage.get(getRightChildIndex(i))) > 0) {
            T holder = storage.get(getRightChildIndex(i));
            storage.set(getRightChildIndex(i), storage.get(i));
            storage.set(i, holder);
            downHeap(getRightChildIndex(i));
        }
    }

    public ArrayList<T> dumpHeap(){
        ArrayList<T> out = new ArrayList<>();
        while (storage.size() != 0){
            out.add(getTop());
        }

        return out;
    }
}
