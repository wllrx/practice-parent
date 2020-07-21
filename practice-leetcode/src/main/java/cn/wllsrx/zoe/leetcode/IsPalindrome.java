package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 回文数
 * <p>
 * 判断一个整数是否是回文数,回文数是指正序(从左到右)和倒序(从右向左)读都是一样的整数
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 **/
public class IsPalindrome {

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(isPalindrome(x));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 ) {
            return false;
        }
        if (x % 10 == 0 && x != 0){
            return false;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        builder.reverse();
        return builder.toString().equals(String.valueOf(x));
    }


}
