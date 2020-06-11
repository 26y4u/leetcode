package double_pointer;
import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world!");
        solution a = new solution();
        int arr1[] = {2, 7, 11, 15};
        a.twoSum(arr1,9);
        int arr2[] = {2,3,1,2,4,3};
        System.out.println(a.minSubArrayLen(7,arr2));
    }
}
