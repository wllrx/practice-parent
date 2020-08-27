package leetcode

/**
 * @author zoe
 **/
object CheckPossibility {

  def main(args: Array[String]): Unit = {
    println(checkPossibility(Array(3, 4, 2, 3)))
  }

  def checkPossibility(nums: Array[Int]): Boolean = {
    var count = 0
    var temp = Int.MinValue
    for (i <- 0 until nums.length - 1) {
      if (nums(i) > nums(i + 1)) {
        count = count + 1
        if (count > 1) {
          return false
        }
        if (nums(i + 1) < temp) nums(i + 1) = nums(i) else nums(i) = temp
      }
      temp = nums(i)
    }
    true
  }

}
