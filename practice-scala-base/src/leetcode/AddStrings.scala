package leetcode

/**
 * @author zoe
 **/
object AddStrings {
  def main(args: Array[String]): Unit = {
    println(addStrings("12345", "67890"))
  }

  def addStrings(num1: String, num2: String): String = {
    var i = num1.length - 1
    var j = num2.length - 1
    var add = 0
    val builder = new StringBuilder
    while (i >= 0 || j >= 0 || add != 0) {
      val x = if (i >= 0) num1.charAt(i) - '0' else 0
      val y = if (j >= 0) num2.charAt(j) - '0' else 0
      val result = x.+(y).+(add)
      builder.append(result.%(10))
      add = result./(10)
      i = i - 1
      j = j - 1
    }
    builder.reverse.toString()
  }

}
