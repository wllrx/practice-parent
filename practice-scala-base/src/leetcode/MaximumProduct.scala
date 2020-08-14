package leetcode

/**
 * @author zoe
 **/
object MaximumProduct {
  def main(args: Array[String]): Unit = {
    println(maximumProduct(Array(9,1,5,6,7,2)))
  }

  def maximumProduct(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val length = nums.length
    (sorted(0)*sorted(1)*sorted(length-1)).max(sorted(length-1)*sorted(length-2)*sorted(length-3))
  }

}
