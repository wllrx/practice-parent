package leetcode

/**
 * @author zoe
 **/
object RestoreString {

  def main(args: Array[String]): Unit = {
    println(restoreString("codeleet",Array(4, 5, 6, 7, 0, 2, 1, 3)))
  }

  def restoreString(s: String, indices: Array[Int]): String = {
    val e = new Array[Char](indices.length)
    val array = s.toCharArray
    for (a <- indices.indices){
        e(indices(a)) = array(a)
    }
    e.mkString
  }
}
