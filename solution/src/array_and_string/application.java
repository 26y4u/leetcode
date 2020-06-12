package array_and_string;
import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        solution a = new solution();
        String str = "Let's take LeetCode contest";
        int[] arr = {0,0,1};
        a.moveZeroes(arr);
    }
}
