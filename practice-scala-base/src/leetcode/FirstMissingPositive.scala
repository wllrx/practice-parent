package leetcode

/**
 * @author zoe
 **/
object FirstMissingPositive {

  def main(args: Array[String]): Unit = {
    println(firstMissingPositive(Array(1, 2, 0)))
  }

  def firstMissingPositive(nums: Array[Int]): Int = {
    val length = nums.length
    for (a <- 0 until length) {
      if (nums(a) <= 0) nums(a) = length + 1
    }
    for (a <- 0 until length) {
      val num = math.abs(nums(a))
      if (num <= length) nums(num - 1) = -math.abs(nums(num - 1))
    }
    for (a <- 0 until length) {
      if (nums(a) > 0) return a + 1
    }
    length + 1
  }
}
