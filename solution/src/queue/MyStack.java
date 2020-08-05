package queue;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 622. 设计循环队列
 * design-circular-queue
 *
 * @author: 1004♥
 * @CreateDate 2020-06-15
 * @UpdateDate 2020-06-15
 */
public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue2.poll();

    }

    /** Get the top element. */
    public int top() {
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();

    }
}
