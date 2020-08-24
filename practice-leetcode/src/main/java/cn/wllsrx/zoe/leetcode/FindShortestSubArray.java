package cn.wllsrx.zoe.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zoe
 *
 * 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length在1到50,000区间范围内。
 * nums[i]是一个在0到49,999范围内的整数。
 **/
public class FindShortestSubArray {

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    private static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(16),
                right = new HashMap<>(16),
                count = new HashMap<>(16);
        int ans = nums.length;
        for (int i = 0; i < ans; i++) {
            int x = nums[i];
            left.putIfAbsent(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        int degree = Collections.max(count.values());
        for (int y : count.keySet()) {
            if (count.get(y) == degree) {
                ans = Math.min(ans, right.get(y) - left.get(y) + 1);
            }
        }
        return ans;
    }
}
