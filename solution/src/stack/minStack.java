package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 622. 设计循环队列
 * design-circular-queue
 *
 * @author: 1004♥
 * @CreateDate 2020-06-15
 * @UpdateDate 2020-06-15
 */

class minStack {
    List<Integer> stack;
    /** initialize your data structure here. */
    public minStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if(stack.size() == 1){
            stack.add(x);
        }
        else {
            stack.add(Math.min(stack.get(stack.size()-2),x));
        }
    }

    public void pop() {
        stack.remove(stack.size()-1);
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.get(stack.size()-1);
    }
    public void outPut(){
        System.out.println(stack.toString());
    }
}
