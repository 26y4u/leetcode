package stack;

import org.w3c.dom.Node;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class solution {

    /**
     * 20. 有效的括号
     * valid-parentheses
     *
     * @author: 1004♥
     * @CreateDate 2020-06-24
     * @UpdateDate 2020-06-24
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == '(' || arr[i] == '{' || arr[i] == '['){
                stack.push(arr[i]);
            }
            else {
                if(stack.size()==0){
                    return false;
                }
                char c = stack.pop();
                if(arr[i] == ')'){
                    if (c != '('){
                        return false;
                    }
                }
                else if(arr[i] == '}'){
                    if (c != '{'){
                        return false;
                    }
                }
                else if(arr[i] == ']'){
                    if (c != '['){
                        return false;
                    }
                }
            }
        }
        return stack.size()==0;
    }
    /**
     * 739. 每日温度
     * daily-temperatures
     *
     * @author: 1004♥
     * @CreateDate 2020-06-24
     * @UpdateDate 2020-06-24
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<Integer>(); // 栈中的数字一定是递减的，遇到比自身大的数字时，出栈，计算距离。
        int[] res = new int[T.length];
        for(int i = 0;i<T.length;i++){
            while (stack.size() != 0 && T[stack.peek()]<T[i]){
                res[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
    public int[] dailyTemperatures1(int[] T) {
        // 动态规划
        int[] res = new int[T.length];
        for(int i = T.length-1;i>=0;i--){
            if(i == T.length-1){
                res[i] = 0;
            }
            else {
                // j = j + res[j],如果没有找到比T[i]大的数字时下一个比T[j]大的数字的下标
                for(int j=i+1;j<T.length+1;j=j+res[j]){
                    if(T[j]>T[i]){
                        res[i] = j-i;
                        break;
                    }
                    else if (res[j] == 0){
                        // 没有比T[j]大的数字了
                        res[i] = 0;
                        break;
                    }
                }

            }
        }
        return res;
    }

    /**
     * 150. 逆波兰表达式求值
     * perfect-squares
     *
     * @author: 1004♥
     * @CreateDate 2020-06-24
     * @UpdateDate 2020-06-24
     */
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s:tokens){
            int temp1 =0,temp2=0;
            switch (s){
                case "+":
                    temp2 = stack.pop();
                    temp1 = stack.pop();
                    stack.push(temp1 + temp2);
                    break;
                case "-":
                    temp2 = stack.pop();
                    temp1 = stack.pop();
                    stack.push(temp1-temp2);
                    break;
                case "*":
                    temp2 = stack.pop();
                    temp1 = stack.pop();
                    stack.push(temp1*temp2);
                    break;
                case "/":
                    temp2 = stack.pop();
                    temp1 = stack.pop();
                    stack.push(temp1/temp2);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.isEmpty()?0:stack.pop();
    }
}

