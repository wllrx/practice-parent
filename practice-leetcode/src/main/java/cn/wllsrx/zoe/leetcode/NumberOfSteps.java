package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 将数字变成 0 的操作次数
 * <p>
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * 示例 2：
 * <p>
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * 示例 3：
 * <p>
 * 输入：num = 123
 * 输出：12
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 10^6
 **/
public class NumberOfSteps {

    public static void main(String[] args) {
        int num = 14;
        System.out.println(numberOfSteps(num));

    }

    private static int numberOfSteps(int num) {
        int i = 0;
        while (num != 0) {
            //判断奇偶 奇数-1 偶数 /2
            if ((num & 1) == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            i++;
        }
        return i;
    }


}
