package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 非递减数列
 * <p>
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 **/
public class CheckPossibility {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }

    private static boolean checkPossibility(int[] nums) {
        int count = 0, temp = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            //出现不满足非递减的情况
            if (nums[i] > nums[i + 1]) {
                //第二次出现非递减时直接返回false
                if (count++ > 0) {
                    return false;
                }
                if (nums[i + 1] < temp) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = temp;
                }
            }
            temp = nums[i];
        }
        return true;
    }

}
