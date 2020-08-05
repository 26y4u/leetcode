package queue_and_stack;

import java.util.*;


public class solution {
    /**
     * 394. 字符串解码
     * decode-string
     *
     * @author: 1004♥
     * @CreateDate 2020-07-24
     * @UpdateDate 2020-07-24
     * @return
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String res = "";
        char[] chars = s.toCharArray();
        for (int i =0;i<s.length();i++){
            if(chars[i] == ']'){
                String str = "";
                char c = ' ';
                while (!stack.isEmpty()){
                    c = stack.peek();
                    if (c!='['){
                        str = stack.pop() + str;
                    }
                    else {
                        stack.pop();
                        break;
                    }
                }
                if (c=='['){
                    String count = "";
                    while((!stack.isEmpty())&&(stack.peek().charValue()>='0'&&stack.peek().charValue()<='9')) {
                        count=stack.pop()+count;
                    }
                    int num = Integer.parseInt(count);
                    for (int j = 0;j<num;j++){
                        res = res+str;
                    }
                }
                char[] temp = res.toCharArray();
                for (int j =0;j<res.length();j++){
                    stack.push(temp[j]);
                }
                res = "";
            }
            else {
                stack.push(chars[i]);
            }
        }
        for (int i =0;i<stack.toArray().length;i++){
            res = res+stack.toArray()[i];
        }
        return res;
    }
    /**
     * 733. 图像渲染
     * flood-fill
     *
     * @author: 1004♥
     * @CreateDate 2020-08-03
     * @UpdateDate 2020-08-03
     * @return
     */
    Queue<int[]> q = new LinkedList<int[]>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length==0){
            return image;
        }
        else if (image[0].length == 0){
            return image;
        }
        int xl = image.length;
        int yl = image[0].length;
        int sign = image[sr][sc];
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!q.isEmpty()){
            int temp[] = q.poll();
            int x = temp[0];
            int y = temp[1];
            image = addQueue(x+1,y,xl,yl,image,sign,newColor);
            image = addQueue(x-1,y,xl,yl,image,sign,newColor);
            image = addQueue(x,y+1,xl,yl,image,sign,newColor);
            image = addQueue(x,y-1,xl,yl,image,sign,newColor);

        }
        return image;
    }
    public int[][]  addQueue(int x,int y,int xl,int yl,int[][] image,int sign, int newColor){
        if (x>=0 && x< xl && y>=0 && y<yl){
            if (image[x][y] == sign && image[x][y] != newColor){
                image[x][y] = newColor;
                q.offer(new int[]{x,y});
            }
        }
        return image;
    }

    /**
     * 542. 01 矩阵
     * 01-matrix
     *
     * @author: 1004♥
     * @CreateDate 2020-08-03
     * @UpdateDate 2020-08-03
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0){
            return matrix;
        }
        else if (matrix[0].length == 0){
            return matrix;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
                else {
                    matrix[i][j] = matrix.length+matrix[0].length;
                }
            }
        }

        int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            // 搜索上下左右四个方向
            for (int[] v : vector) {
                int r = s[0] + v[0], c = s[1] + v[1];
                if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] > matrix[s[0]][s[1]] + 1) {
                    matrix[r][c] = matrix[s[0]][s[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return matrix;
    }

    /**
     * 841. 钥匙和房间
     * keys-and-rooms
     *
     * @author: 1004♥
     * @CreateDate 2020-08-03
     * @UpdateDate 2020-08-03
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map map = new HashMap();
        int N = rooms.size();
        map.put(0,0);
        dfs(rooms,0,map);
        return map.size() == N;
    }
    public void dfs(List<List<Integer>> rooms,int value,Map map){
        for (int j = 0;j<rooms.get(value).size();j++){
            int temp = rooms.get(value).get(j);
            if (!map.containsKey(temp)){
                map.put(temp,temp);
                dfs(rooms,temp,map);
            }
        }
    }


}

