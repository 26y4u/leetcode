package queue_and_stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        solution a = new solution();
        String str = "3[a]";
        int[][] image = new int[3][3];
        image[0][0] = 1;
        image[0][1] = 1;
        image[0][2] = 1;
        image[1][0] = 1;
        image[1][1] = 1;
        image[1][2] = 0;
        image[2][0] = 1;
        image[2][1] = 0;
        image[2][2] = 1;
//        a.floodFill(image,1,1,2);
//        a.updateMatrix(image);
//        System.out.println(a.decodeString(str));
        int[][] arr = { {1},{2},{3},{}};

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<Integer>();
        list1.add(1);
        list2.add(2);
        list3.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        a.canVisitAllRooms(list);
        ;

    }
}
