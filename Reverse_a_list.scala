package Practice

class Rev
{
  def reverse(a: String):String =
  (for(i <- a.length - 1 to 0 by -1) yield a(i)).mkString

  val a="minimum"
  println(a.reverse)
}
object Reverse_a_list extends App {
  val s= new Rev
 print( s.reverse("shivam"))

}
