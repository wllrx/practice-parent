package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 判定字符是否唯一
 * <p>
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * <p>
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 **/
public class IsUnique {

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(isUnique(str));

    }

    private static boolean isUnique(String str) {
        for (char s : str.toCharArray()){
            //判断字符第一次出现的索引和最后一次出现的索引是否相同,相同无重复,不同有重复
            if (str.indexOf(s) != str.lastIndexOf(s)) {
                return false;
            }
        }
        return true;
    }

}
