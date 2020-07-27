package cn.wllsrx.zoe.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoe
 * <p>
 * 整数的各位积和之差
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 **/
public class SubtractProductAndSum {

    public static void main(String[] args) {
        int n = 234;
        System.out.println(subtractProductAndSum(n));
    }


    private static int subtractProductAndSum(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char c : chars) {
            list.add((int) c - 48);
        }
        return list.stream()
                .reduce((a, b) -> a * b)
                .orElse(0) - list.stream()
                .reduce((Integer::sum))
                .orElse(0);

    }

}
