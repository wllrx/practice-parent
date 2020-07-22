package cn.wllsrx.zoe.leetcode;

import java.util.stream.IntStream;

/**
 * @author zoe
 * <p>
 * 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 **/
public class MinArray {

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        System.out.println(minArray(numbers));
    }

    private static int minArray(int[] numbers) {
        return IntStream.of(numbers).min().orElse(0);
    }

}
