package cn.wllsrx.zoe.leetcode;

import java.util.Arrays;

/**
 * @author zoe
 * <p>
 * 一维数组的动态和
 * <p>
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 **/
public class RunningSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    private static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] numbers = new int[length];
        int a = 0;
        for (int i = 0; i < length; i++) {
            a += nums[i];
            numbers[i] = a;
        }
        return numbers;
    }


}
