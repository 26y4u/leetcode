package stack;

import org.w3c.dom.Node;

import javax.swing.*;
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

    /**
     * 133. 克隆图(深拷贝)
     * clone-graph
     *
     * @author: 1004♥
     * @CreateDate 2020-06-29
     * @UpdateDate 2020-06-29
     */
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for(Node neighbor : node.neighbors){
            if(map.containsKey(neighbor)){
                copy.neighbors.add(map.get(neighbor));
            }else{
                copy.neighbors.add(cloneGraph(neighbor));
            }
        }
        return copy;
    }

    /**
     * 494. 目标和(枚举)
     * target-sum
     *
     * @author: 1004♥
     * @CreateDate 2020-06-30
     * @UpdateDate 2020-06-30
     */
    int count = 0;
    public void dfs(int i,int sum,int[] nums,int S){
        if(sum == S && i == nums.length){
            count++;
        }
        else {
            dfs(i+1,sum+nums[i],nums,S);
            dfs(i+1,sum-nums[i],nums,S);
        }
    }
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0,i = 0;
        dfs(i,sum,nums,S);
        return count;
    }

    /**
     * 494. 目标和(动态规划)
     * target-sum
     *
     * SUM(正值) + (-)SUM(负值) = target
     * SUM(正值) + SUM(负值) = SUM
     * 2*SUM(正值)-SUM = target
     * 问题转化为-> 求几个值加起来=(SUM+TARGET)/2时的解法
     * ∴ SUM+target为奇数时，解法为0
     *
     * dp[i]: 目标和为i的解法数量  i=(sum+target)/2 dp[0]: 1;目标和为0只有一种解法
     * dp[i] = dp[i-nums[0]]+...+dp[i-nums[j]]; j=0,1,2,...,nums.length-1;
     *
     * @author: 1004♥
     * @CreateDate 2020-06-30
     * @UpdateDate 2020-06-30
     */

    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 > 0) {
            return 0;
        }
        int s = (sum + S)/2; //转化为求dp[s]
        int dp[] = new int[s+1];
        dp[0] = 1;
        for(int i = 0;i<nums.length;i++){  // 保证每个数据只添加或删除一次，外层index遍历
            for (int j = s;j >= nums[i];j--)
                dp[j] += dp[j - nums[i]];
        }
        return dp[s];
    }
    /**
     * 94. 二叉树的中序遍历
     * binary-tree-inorder-traversal
     *
     * @author: 1004♥
     * @CreateDate 2020-07-02
     * @UpdateDate 2020-07-02
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {// 递归
        if (root == null){
            return list;
        }
        if(root.left != null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right!=null){
            inorderTraversal(root.right);
        }
        return list;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {// 用栈
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

