package cn.wllsrx.zoe.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoe
 * <p>
 * 数组中重复的数据
 * <p>
 * 给定一个整数数组a,其中1<=a[i]<=n(n为数组长度),其中有些元素出现两次而其他元素出现一次.
 * 找到所有出现两次的元素
 * 不用任何的额外空间并在O(n)事故华北复杂度内解决这个问题
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 **/
public class FindDuplicates {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0) {
                res.add(Math.abs(index+1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }

}
