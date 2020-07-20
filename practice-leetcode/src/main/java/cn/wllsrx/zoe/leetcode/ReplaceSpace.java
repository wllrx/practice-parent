package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 替换空格
 * <p>
 * 实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 **/
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    private static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }


}
