package array_and_string;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class solution {

    /**
     * 118. 杨辉三角
     * pascals-triangle
     *
     * @author: lzx♥
     * @CreateDate 2020-06-12
     * @UpdateDate 2020-06-12
     */
    public List<List<Integer>> generate(int numRows) {
        int[][] array = new int[numRows][numRows];
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List<Integer> e = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || j == i) {
                    array[i][j] = 1;
                    e.add(array[i][j]);
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                    e.add(array[i][j]);
                }
            }
            list.add(e);
            System.out.println(list);
        }
        return list;
    }

    /**
     * 119. 杨辉三角 II
     * pascals-triangle-ii
     *
     * @author: lzx♥
     * @CreateDate 2020-06-12
     * @UpdateDate 2020-06-12
     */
    public List<Integer> getRow(int rowIndex) {
        int[][] array = new int[rowIndex][rowIndex];
        List<Integer> e = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || j == i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
                if (i == rowIndex) {
                    e.add(array[i][j]);
                }
            }
        }
        return e;
    }

    /**
     * 557. 反转字符串中的单词 III
     * reverse-words-in-a-string-iii
     *
     * @author: lzx♥
     * @CreateDate 2020-06-12
     * @UpdateDate 2020-06-12
     */
    public String reverseWords(String s) {
        String str[] = s.split(" ");
        String res = "";
        for (int i = 0; i < str.length; i++) {
            res = res + new StringBuffer(str[i]).reverse().toString() + " ";
        }
        return res.trim();
    }

    /**
     * 153. 寻找旋转排序数组中的最小值
     * find-minimum-in-rotated-sorted-array
     *
     * @author: lzx♥
     * @CreateDate 2020-06-12
     * @UpdateDate 2020-06-12
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        else {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return Math.min(nums[0], nums[i]);
                }
            }
            return nums[0];
        }
    }

    /**
     * 26. 删除排序数组中的重复项
     * find-minimum-in-rotated-sorted-array
     *
     * @author: lzx♥
     * @CreateDate 2020-06-12
     * @UpdateDate 2020-06-12
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        if (nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int k = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * 283. 移动零
     * move-zeroes
     *
     * @author: lzx♥
     * @CreateDate 2020-06-12
     * @UpdateDate 2020-06-12
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}

