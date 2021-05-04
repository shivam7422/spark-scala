package Practice
import io._

class Palin
{
  def Pal(s:String):Unit={
   // println(" Enter the text")
    val sg= readLine()
    val e= sg.toLowerCase
    if(sg==sg.reverse)
      print("true")
    else
      print("false")
  }
  /*
  def pali(s:String):Boolean={
  val e= s.toLowerCase
    e==e.reverse
  }
  println(" Enter the text")
  val input= readLine()
  if(pali(input))
    {
      print("palindrome")
    }
  else("not palindrome")
  */
}

object palindrome extends  App{

  val s= new Palin
  s.Pal("shivam")

}
