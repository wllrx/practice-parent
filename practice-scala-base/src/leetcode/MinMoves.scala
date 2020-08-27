package leetcode

/**
 * @author zoe
 **/
object MinMoves {

  def main(args: Array[String]): Unit = {
    println(minMoves(Array(1, 2, 3)))
  }

  def minMoves(nums: Array[Int]): Int = {
    var count = 0
    val sorted = nums.sorted
    var a = sorted.length - 1
    while (a > 0) {
      count += sorted(a) - sorted(0)
      a -= 1
    }
    count
  }

}
