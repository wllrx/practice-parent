package cn.wllsrx.zoe.leetcode;

import java.util.Arrays;

/**
 * @author zoe
 * <p>
 * 交换数字
 * <p>
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 * <p>
 * numbers.length == 2
 **/
public class SwapNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(swapNumbers(new int[]{1, 2})));
    }

    private static int[] swapNumbers(int[] numbers) {
        return new int[]{numbers[1], numbers[0]};
    }
}
