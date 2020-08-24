package leetcode

import scala.collection.mutable.ListBuffer

/**
 * @author zoe
 **/
object FindDisappearedNumbers {

  def main(args: Array[String]): Unit = {
    println(findDisappearedNumbers1(Array(4, 3, 2, 7, 8, 2, 3, 1)).mkString(","))
  }

  /**
   * 此方法超出内存限制
   *
   * @param nums 数组
   * @return 结果
   */
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    var l = ListBuffer[Int]()
    for (a <- 1 to nums.length) {
      if (!nums.contains(a)) {
        l += a
      }
    }
    l.toList
  }

  def findDisappearedNumbers1(nums: Array[Int]): List[Int] = {
    var res = new ListBuffer[Int]
    nums.indices.foreach(i => {
      val m = math.abs(nums(i)) - 1
      nums(m) = if (nums(m) > 0) -nums(m) else nums(m)
    })
    nums.indices.foreach(i => if (nums(i) > 0) res += (i + 1))
    res.toList
  }
}
