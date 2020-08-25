package leetcode

/**
 * @author zoe
 **/
object HIndex {

  def main(args: Array[String]): Unit = {
    println(hIndex(Array(3, 0, 6, 1, 5)))
  }

  def hIndex(citations: Array[Int]): Int = {
    var i = 0
    val sorted = citations.sorted
    while (i < sorted.length && sorted(sorted.length - 1 - i) > i) {
      i = i + 1
    }
    i
  }


}
