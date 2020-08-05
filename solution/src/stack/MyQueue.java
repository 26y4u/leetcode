package stack;


import java.util.Stack;

/**
 * 622. 设计循环队列
 * design-circular-queue
 *
 * @author: 1004♥
 * @CreateDate 2020-06-15
 * @UpdateDate 2020-06-15
 */
public class MyQueue {
    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack.isEmpty()){
            return 0;
        }
        else {
            return stack.remove(0);
        }
    }

    /** Get the front element. */
    public int peek() {
        if(stack.isEmpty()){
            return 0;
        }
        else {
            return stack.get(0);
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
