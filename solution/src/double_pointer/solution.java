package double_pointer;

public class solution {

    /**
     * 167. 两数之和 II - 输入有序数组
     * two-sum-ii-input-array-is-sorted
     * @author:  lzx♥
     * @CreateDate 2020-06-10
     * @UpdateDate 2020-06-10
     */
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length-1;

        while (numbers[index1]+numbers[index2]!=target){
            if(numbers[index1]+numbers[index2]>target){
                index2--;
            }
            else if (numbers[index1]+numbers[index2]<target){
                index1++;
            }
        }
        return new int[]{index1 + 1, index2 + 1};
    }
}
