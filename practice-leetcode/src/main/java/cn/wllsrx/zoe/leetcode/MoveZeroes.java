package cn.wllsrx.zoe.leetcode;

import java.util.Arrays;

/**
 * @author zoe
 * <p>
 * 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 **/
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    private static void moveZeroes(int[] nums) {
        //非零指针
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            //非零项才需要操作
            if (nums[i] != 0) {
                //判断两个指针之间的差异，如果一样，说明完全没移动过项（前面所有项都是非零）
                //若不一样，即前面已经移动过项（出现过0项了），对于当前值，直接往前移动；对于i的节点，直接置0，因为已经移走了
                //注意 对于i=idx的情况，idx指针也是要++的，只是相当于不移动，但是非零指针也要指向下一个位置
                if (idx != i) {
                    nums[idx] = nums[i];
                    nums[i] = 0;
                }
                //移动非零指针
                idx++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
