package cn.wllsrx.zoe.leetcode;

import java.util.stream.IntStream;

/**
 * @author zoe
 * <p>
 * 第三大的数
 * <p>
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 **/
public class ThirdMax {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
    }

    private static int thirdMax(int[] nums) {
        int[] ints = IntStream.of(nums).distinct().sorted().toArray();
        if (ints.length < 3){
            return IntStream.of(ints).max().orElse(0);
        }
        return ints[ints.length -3];
    }
}
