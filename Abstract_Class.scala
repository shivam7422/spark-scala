package programs

// A class which is declared with abstract keyword is called abstraction. It is a process in which we have to hide the
// complexity and functionality to the user.
// we can apply abstraction on three ways- class, methods and variables.
abstract class ATC
{
  def demo: Unit =
  {
    println(" This is me ")
  }
  def demo1()
}
abstract class ant(name:String,id:Int)
{
  def ass()
  def ass1: Unit ={
    println(name +" "+ id)
  }
}
class ATC1 extends ATC{
  def demo1: Unit ={
    println(" This is me2")
  }
}
class ant2(name:String,id:Int) extends ant(name, id)
{
   def ass: Unit =
   {
     println("name "+ name)
   }

}


object Abstract_Class extends App{

  val s= new ATC1
  s.demo
  s.demo1
val e= new ant2("train",1)
  e.ass;e.ass1
}
