package leetcode

/**
 * @author zoe
 **/
object SmallerNumbersThanCurrent {
  def main(args: Array[String]): Unit = {
    println(smallerNumbersThanCurrent(Array(8, 1, 2, 2, 3)).mkString("Array(", ", ", ")"))
  }

  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    nums.map(a => nums.count(_ < a))
  }
}
