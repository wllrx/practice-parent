package leetcode

import scala.collection.mutable.ListBuffer

/**
 * @author zoe
 **/
object FindDuplicates {

  def main(args: Array[String]): Unit = {
    println(findDuplicates(Array(4, 3, 2, 7, 8, 2, 3, 1)))
  }

  def findDuplicates(nums: Array[Int]): List[Int] = {
    val l = ListBuffer[Int]()
    nums.indices.foreach(i => {
      val m = math.abs(nums(i)) - 1
      if (nums(m) <0) l+=math.abs(m+1) else nums(m) = -nums(m)
    })
    l.toList
  }


}
