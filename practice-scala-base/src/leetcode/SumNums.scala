package leetcode

/**
 * @author zoe
 *         求1+2+...+n
 **/
object SumNums {

  def main(args: Array[String]): Unit = {
    println(sumNums(3))
  }

  def sumNums(n: Int): Int = {
    n * 1 + n * (n - 1) / 2
  }
}
