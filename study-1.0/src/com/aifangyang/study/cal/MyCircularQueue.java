package com.aifangyang.study.cal;

public class MyCircularQueue {
    // store elements
    private int[] data;
    // a pointer to indicate the start position
    private int head = 0;
    // a pointer to indicate the tail position
    private int queLength = 0;
    private int tail = 0;
    // the size of queue
    private int queueSize;
    private int one=1;
    private int minusOne=-1;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queueSize = k;
        data = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queLength++;
        tail = (head+queLength+minusOne)%queueSize;
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head+one)%queueSize;
        queLength--;
        return true;
    }
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return minusOne;
        }
        return data[head];
    }
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return minusOne;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return queLength == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return queLength == queueSize;
    }
}
