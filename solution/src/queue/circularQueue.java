package queue;

/**
 * 622. 设计循环队列
 * design-circular-queue
 *
 * @author: 1004♥
 * @CreateDate 2020-06-15
 * @UpdateDate 2020-06-15
 */

class circularQueue {

    Integer[] data;
    // a pointer to indicate the start position
    private int p_start;
    private int p_end; //下一个插入的位置下标
    private int len;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public circularQueue(int k) {
        data = new Integer[k];
        p_start = 0;
        p_end = 0;
        len = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        else {
            data[p_end] = value;
            p_end = (p_end+1)%len;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        else {
            data[p_start] = null;
            p_start = (p_start+1)%len;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) {
            return -1;
        }else {
            return data[p_start];
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }else {
            if(p_end!=0)return data[p_end-1];
            else return data[data.length-1];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(p_start==p_end&&data[p_start]==null) {
            return true;
        }else {
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(p_start==p_end&&data[p_start]!=null) {
            return true;
        }else {
            return false;
        }
    }
}
