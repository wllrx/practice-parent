package cn.wllsrx.zoe.leetcode

/**
 * @author zoe
 *
 * 拿硬币
 **/
object MinCount {

  def main(args: Array[String]): Unit = {
    println(minCount(Array(4,2,1)))
  }

  def minCount(coins: Array[Int]): Int = {
    var value=0
    for (x <- coins) {
      value+= x/2+x%2
    }
    value
  }
}
