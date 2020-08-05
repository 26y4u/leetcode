package queue;

import org.w3c.dom.Node;

import java.util.*;

public class solution {

    /**
     * 200. 岛屿数量
     * number-of-islands
     *
     * @author: 1004♥
     * @CreateDate 2020-06-15
     * @UpdateDate 2020-06-15
     */
    public void bfs(char[][] grid,int i,int j) {
        if (i<0||j<0||i>grid.length||j>grid[i].length){
            return;
        }
        if (grid[i][j] == '0' ){
            return;
        }
        else if (grid[i][j] == '1'){
            grid[i][j] = '0';
            bfs(grid,i+1,j);
            bfs(grid,i-1,j);
            bfs(grid,i,j+1);
            bfs(grid,i,j-1);
        }
    }
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null || grid.length == 0){
            return num;
        }
        Queue<Node> q = new LinkedList<Node>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
                if(grid[i][j] == '1'){
                    num++;
                    bfs(grid,i,j);
                }
            }

        }
        return num;
    }

    /**
     * 752. 打开转盘锁
     * open-the-lock
     *
     * @author: 1004♥
     * @CreateDate 2020-06-18
     * @UpdateDate 2020-06-18
     */
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(); //死亡数据集 去重
        for(String d:deadends){
            dead.add(d);
        }

        Queue<String> q = new LinkedList<String>();
        q.offer("0000");
        q.offer(null); // 取到null表示该层数据已遍历完

        Set<String> been = new HashSet(); //已经遍历的结果集 去重
        been.add("0000");

        int depth = 0; // 层数
        while (!q.isEmpty()){
            // 队列非空
            String node = q.poll();// 取出队列第一个节点
            if(node == null){ // 该层遍历完成
                depth++;
                if(q.peek() != null){// 若下一层可到达的结点为空 -> 已经没有可以到达的结点了
                    q.offer(null); // 加入下一层
                }
            }
            else if(node.equals(target)){
                return depth;
            }
            else if (!dead.contains(node)){ // 该节点不在死亡数据集中
                // 遍历加入可到达的下一层结点
                for(int i = 0;i<4;i++){
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10; // 第i位替换成y
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);// 相邻的结点
                        if (!been.contains(nei)) {
                            been.add(nei);
                            q.offer(nei);
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 279. 完全平方数 (BFS)
     * perfect-squares
     *
     * @author: 1004♥
     * @CreateDate 2020-06-18
     * @UpdateDate 2020-06-18
     */
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> been = new HashSet<>();
        q.offer(n);
        been.add(n);
        int depth = 0;
        while (!q.isEmpty()){
            int len = q.size();
            depth++;
            for(int i = 0;i<len;i++){
                int node = q.poll();
                for (int j=1;j*j<=node;j++){
                    if(node-j*j == 0){
                        return depth;
                    }
                    else {
                        if(!been.contains(node-j*j)){
                            been.add(node-j*j);
                            q.offer(node-j*j);
                        }
                    }
                }
            }
        }
        return depth;
    }

    /**
     * 279. 完全平方数 (动态规划)
     * perfect-squares
     *
     * @author: 1004♥
     * @CreateDate 2020-06-18
     * @UpdateDate 2020-06-18
     */
    public int numSquares1(int n) {
        int arr[] = new int[n+1];
        arr[0] = 0;
        for(int i = 1;i<n+1;i++){
            arr[i] = i;
            for(int j = 1;i-j*j>=0;j++){
                arr[i] = Math.min(arr[i],arr[i-j*j]+1);
            }
        }
        return arr[n];
    }
}

