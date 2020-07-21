package cn.wllsrx.zoe.leetcode;

/**
 * @author zoe
 * <p>
 * 猜数字
 * <p>
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * <p>
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * 示例 1：
 * <p>
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 *  
 **/
public class Game {

    public static void main(String[] args) {
        int[] guess = {2, 2, 3}, answer = {3,2,1};
        System.out.println(game(guess, answer));
    }

    private static int game(int[] guess, int[] answer) {
        //判断两个数组同一下标的值是否相同,相同代表猜对
        int i = 0;
        int length = guess.length;
        for (int j = 0; j < length; j++) {
            if (guess[j] == answer[j]) {
                i++;
            }
        }
        return i;
    }


}
