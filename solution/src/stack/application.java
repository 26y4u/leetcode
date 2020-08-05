package stack;

import java.io.IOException;
public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        minStack cq = new minStack();
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false

    }
}
