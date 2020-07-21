package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 旋转字符串
 * <p>
 * 给定两个字符串, A 和 B。
 * <p>
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * <p>
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 * <p>
 * A 和 B 长度不超过 100
 **/
public class RotateString {

    public static void main(String[] args) {
        String a = "abcde", b = "abced";
        System.out.println(rotateString(a, b));
    }

    private static boolean rotateString(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }

}
