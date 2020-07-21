package cn.wllsrx.zoe.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zoe
 * <p>
 * 糖果最多的孩子
 * <p>
 * 你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * <p>
 * 输入：candies = [2,3,5,1,3], extraCandies = 3
 * 输出：[true,true,true,false,true]
 * 解释：
 * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
 * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
 * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
 * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 **/
public class KidsWithCandies {

    public static void main(String[] args) {
        int[] candies = {12,1,12};
        int extraCandies = 10;
        System.out.println(kidsWithCandies(candies,extraCandies));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //找出数组最大值,每个元素加上额外糖果大于等于最大值时成为拥有糖果最多的孩子
        List<Boolean> booleanList = new ArrayList<>();
        int max = Arrays.stream(candies).max().orElseGet(() -> 0);
        for (int a : candies) {
            booleanList.add(a + extraCandies >= max);
        }
        return booleanList;
    }


}
