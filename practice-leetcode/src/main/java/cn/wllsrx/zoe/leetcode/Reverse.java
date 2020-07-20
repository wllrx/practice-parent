package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 **/
public class Reverse {

    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {
        Long abs = Math.abs(Long.valueOf(x));
        String s = String.valueOf(abs);
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        builder.reverse();
        if (x >= 0) {
            if (Long.parseLong(builder.toString()) > 2147483647) {
                return 0;
            }
            return Integer.parseInt(builder.toString());
        }
        if (-Long.parseLong(builder.toString()) < -2147483648) {
            return 0;
        }
        return -Integer.parseInt(builder.toString());
    }

}
