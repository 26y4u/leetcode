package stack;

import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        minStack cq = new minStack();
//        cq.push(-10);
//        cq.outPut();
        solution sq = new solution();
        String[] arr = {"4","13","5","/","+"};
        sq.evalRPN(arr);


    }
}
