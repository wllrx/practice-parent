package leetcode

/**
 * @author zoe
 **/
object MoveZeroes {

  def main(args: Array[String]): Unit = {
    moveZeroes(Array(0, 1, 0, 3, 12))
  }

  def moveZeroes(nums: Array[Int]): Unit = {
    var index = 0
    for (i <- nums.indices) {
      if (nums(i) != 0) {
        if (index != i) {
          nums(index) = nums(i)
          nums(i) = 0
        }
        index += 1
      }
    }
    println(nums.mkString(","))
  }

}
