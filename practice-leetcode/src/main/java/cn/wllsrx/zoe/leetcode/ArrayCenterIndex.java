package cn.wllsrx.zoe.leetcode;

import java.util.Arrays;

/**
 * @author zoe
 * <p>
 * 寻找数组的中心索引
 * <p>
 * 给定一个整数类型的数组 nums 返回数组的中心索引
 * <p>
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。没有中心索引返回-1
 **/
public class ArrayCenterIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int index = pivotIndex(nums);
        System.out.println(index);
    }

    private static int pivotIndex(int[] nums) {
        //从左求和
        int leftNum = 0;
        //数组总和
        int sum = Arrays.stream(nums).sum();
        //索引从0开始 当前索引的值加上之前的值
        for (int i = 0; i <= nums.length - 1; i++) {
            if (i != 0) {
                leftNum += nums[i - 1];
            }
            if (sum - leftNum - nums[i] == leftNum) {
                return i;
            }
        }
        return -1;
    }
}
