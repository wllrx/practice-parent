package leetcode

/**
 * @author zoe
 **/
object FindPoisonedDuration {
  def main(args: Array[String]): Unit = {
    println(findPoisonedDuration(Array(1,4),2))
  }

  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    var num = 0
    val length = timeSeries.length
    if (length == 0) return 0 else {
      for (i <- 0 until length-1) {
        num += (timeSeries(i + 1) - timeSeries(i)).min(duration)
      }
    }
    num + duration
  }
}
