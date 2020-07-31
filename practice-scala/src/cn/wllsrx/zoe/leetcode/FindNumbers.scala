package cn.wllsrx.zoe.leetcode

/**
 * @author zoe
 *
 * 统计位数为偶数的数字
 **/
object FindNumbers {

  def main(args: Array[String]): Unit = {
    println(findNumbers(Array(555, 901, 482, 1771)))
  }

  def findNumbers(nums: Array[Int]): Int = {
    nums.count(_.toString.length % 2 ==0)
  }

}
