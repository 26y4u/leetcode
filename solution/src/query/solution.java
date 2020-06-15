package query;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}

