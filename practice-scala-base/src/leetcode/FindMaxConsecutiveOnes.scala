package leetcode

/**
 * @author zoe
 **/
object FindMaxConsecutiveOnes {

  def main(args: Array[String]): Unit = {
      println(findMaxConsecutiveOnes(Array(1, 1, 0, 1, 1, 1, 0)))
  }

  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var count = 0
    var max = 0
    for (a <- nums){
      count = if (a==0) 0 else count+1
      max = count.max(max)
    }
    max
  }
}
