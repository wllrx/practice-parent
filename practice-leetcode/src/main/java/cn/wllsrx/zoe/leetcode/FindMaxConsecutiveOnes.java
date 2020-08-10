package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 最大连续1的个数
 * <p>
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含0 和1。
 * 输入数组的长度是正整数，且不超过 10,000
 **/
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1,0}));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0 ;
        int max = 0 ;
        for (int a : nums){
            count = a == 0 ? 0 : count+1;
            max = Math.max(count,max);
        }
        return max;
    }

}
