package cn.wllsrx.zoe.leetcode;

import java.util.Arrays;

/**
 * @author zoe
 * <p>
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 **/
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int search = search(nums, target);
        System.out.println(search);
    }

    private static int search(int[] nums, int target) {
        //Arrays.binarySearch()只能用于有序数组  ArrayUtils.contains(nums,target)
        int binarySearch = Arrays.binarySearch(nums, target);
        int length = nums.length;
        if (binarySearch >= 0) {
            return binarySearch;
        } else {
            int[] numbers = new int[length + 1];
            int numLength = numbers.length;
            for (int i = 0; i < numLength; i++) {
                if (i < length) {
                    numbers[i] = nums[i];
                } else {
                    numbers[i] = target;
                }
            }
            Arrays.sort(numbers);
            for (int i = 0; i < numLength; i++) {
                if (numbers[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }
}
