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

    /**
     * 27. 移除元素
     * remove-element
     * @author:  lzx♥
     * @CreateDate 2020-06-11
     * @UpdateDate 2020-06-11
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 485. 最大连续1的个数
     * max-consecutive-ones
     * @author:  lzx♥
     * @CreateDate 2020-06-11
     * @UpdateDate 2020-06-11
     */
    public int findMaxConsecutiveOnes(int[] nums) {

        int max= 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if (nums[i] == 1){
                count++;
            }
            else{
                System.out.println(count);
                max = Math.max(max,count);
                count = 0;
            }
        }
        max = Math.max(max,count);
        return max;
    }
    /**
     * 209. 长度最小的子数组
     * minimum-size-subarray-sum
     * @author:  lzx♥
     * @CreateDate 2020-06-11
     * @UpdateDate 2020-06-11
     */
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        if (sum<s){
            return 0;
        }
        sum = 0;
        int m = 0;
        int n = 0;
        while (m <= nums.length-1){
            sum = sum + nums[n];
            if(sum>=s){
                len = Math.min(n-m+1, len);
                sum = sum-nums[m]-nums[n];
                m++;
            }
            else {
                if(n<nums.length-1){
                    n++;
                }
                else return len;
            }
        }
        return len;
    }
    public int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        if (sum<s){
            return 0;
        }
        for(int i = 0;i<nums.length;i++){
            sum = 0;
            for (int j = i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum>=s){
                    len = Math.min(len,j-i+1);
                    break;
                }
            }
        }
        return len;
    }
}
