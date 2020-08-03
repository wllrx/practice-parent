package leetcode

/**
 * @author zoe
 **/
object ReverseLeftWords {
  def main(args: Array[String]): Unit = {
    println(reverseLeftWords("abcdefg", 2))
  }

  def reverseLeftWords(s: String, n: Int): String = {
    s.substring(n) ++ s.substring(0, n)
  }

}
