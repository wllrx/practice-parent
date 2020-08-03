package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2的长度都小于 5100.
 * num1 和num2 都只包含数字0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式。
 **/
public class AddStrings {

    public static void main(String[] args) {
        String num1 = "12245", num2 = "6654";
        System.out.println(addStrings(num1, num2));
    }

    private static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            //从尾数开始 两个字符串的对应数字开始相加 再加上进位
            int result = x + y + add;
            builder.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }


}
