package leetcode

/**
 * @author zoe
 **/
object FindErrorNums {

  def main(args: Array[String]): Unit = {
    println(findErrorNums(Array(1, 2, 2, 4)).mkString(","))
  }

  def findErrorNums(nums: Array[Int]): Array[Int] = {
    var dup = -1
    var missing = -1
    val length = nums.length
    for (i <- 1 to length) {
      var count = 0
      for (num <- 0 until length) {
        if (nums(num) == i) {
          count += 1
        }
      }
      if (count == 2) {
        dup = i
      } else if (count == 0) {
        missing = i
      }
    }
    Array(dup, missing)
  }

}
