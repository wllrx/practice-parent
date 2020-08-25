package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 **/
public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }

    private static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < length; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

}
