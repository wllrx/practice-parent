package leetcode

/**
 * @author zoe
 **/
object SwapNumbers {

  def main(args: Array[String]): Unit = {
    println(swapNumbers(Array(1, 2)).mkString(","))
  }

  def swapNumbers(numbers: Array[Int]): Array[Int] = {
    Array(numbers(1), numbers(0))
  }
}
