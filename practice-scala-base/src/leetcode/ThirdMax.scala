package leetcode

/**
 * @author zoe
 **/
object ThirdMax {

  def main(args: Array[String]): Unit = {
    println(thirdMax(Array(1, 2, 2, 5, 3, 5)))
  }

  def thirdMax(nums: Array[Int]): Int = {
    val array = nums.distinct.sorted
    if (array.length < 3) array.max else array(array.length -3)
  }

}
