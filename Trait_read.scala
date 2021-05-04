package programs
/*
when we don't know the complete information about the requirements then we will go for trait.
It contains sub class, abstract and non abstract methods
we can't create object of the class.
it can't have constructors. one trait can extends multiple traits.

*/
trait tickets
{
  def trains()

  def train1(name:String): Unit =
  {
    println(name)
  }

}
class Trains extends tickets
{
  def trains: Unit ={
    println("ticket Confirmed")
  }
}

object Trait_read extends App {

  val s= new Trains
      s.trains
  s.train1("Train")
  //val se= new tickets{1}
}
