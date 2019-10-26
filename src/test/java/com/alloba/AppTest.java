package com.alloba;


import org.junit.Test;

public class AppTest 
{
    @Test
    public void heapCheck(){
        MinHeap<Double> heap = new MinHeap<>();
        heap.insert(4.0);
        heap.insert(8.0);
        heap.insert(5.0);
        heap.insert(6.0);
        heap.insert(4.0);
        heap.insert(7.0);
        heap.insert(3.0);
        heap.insert(8.1);
        heap.insert(5.1);
        heap.insert(6.1);
        heap.insert(4.1);
        heap.insert(7.1);
        heap.insert(3.9);
        heap.insert(4.1);

        System.out.println(heap.toString());
        System.out.println(":dumpheap:");
        System.out.println(heap.dumpHeap());
    }
}
