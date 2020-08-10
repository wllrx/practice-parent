package cn.wllsrx.zoe.leetcode;

import java.util.stream.IntStream;

/**
 * @author zoe
 * 求1+2+...+n
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出:6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出:45
 * <p>
 * 限制：
 * <p>
 * 1 <= n<= 10000
 **/
public class SumNums {

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    private static int sumNums(int n) {
//        return n*1 + n*(n-1)/2;
        return IntStream.rangeClosed(1, n).sum();
    }

}
