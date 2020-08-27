package cn.wllsrx.zoe.leetcode;

import java.util.Arrays;

/**
 * @author zoe
 * <p>
 * 最小移动(操作)次数使数组元素相等
 * <p>
 * 给定一个长度为n的非空整数数组,找到让数组所有元素相等的最小操作次数,每次移动将会使n-1个元素增加1
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 3
 * <p>
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 **/
public class MinMoves {

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 3}));
    }

    private static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }
}
