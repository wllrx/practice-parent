package cn.wllsrx.zoe.leetcode;

import java.util.*;

/**
 * @author zoe
 * <p>
 * 找到所有数组中消失的数字
 * <p>
 * 给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 **/
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, true);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 使用list 执行超时
     *
     * @param nums 数组
     * @return 结果
     */
    private static List<Integer> timeOutFunction(int[] nums) {
        List<Integer> num = new ArrayList<>();
        List<Integer> tag = new ArrayList<>();
        for (int a : nums) {
            num.add(a);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!num.contains(i)) {
                tag.add(i);
            }
        }
        return tag;
    }
}
