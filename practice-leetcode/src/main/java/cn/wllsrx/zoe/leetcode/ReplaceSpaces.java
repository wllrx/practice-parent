package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * URL化
 * <p>
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * <p>
 * 提示：
 * <p>
 * 字符串长度在[0, 500000]范围内。
 **/
public class ReplaceSpaces {

    public static void main(String[] args) {
        String s = "          ";
        int length = 5;
        System.out.println(replaceSpaces(s,length));
    }

    private static String replaceSpaces(String s, int length) {
        return s.substring(0, length).replace(" ","%20");
    }
}
