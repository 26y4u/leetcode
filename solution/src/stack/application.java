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
        int[] xx = {1,1,1,1,1};
        sq.findTargetSumWays1(xx,3);
        solution.TreeNode tr1 = new solution.TreeNode(1);
        solution.TreeNode tr2 = new solution.TreeNode(2);
        solution.TreeNode tr3 = new solution.TreeNode(3);
        tr1.right = tr2;
        tr2.left = tr3;
        sq.inorderTraversal1(tr1);

    }
}
