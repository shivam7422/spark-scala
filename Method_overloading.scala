package programs
// More than one forms is called polymorphism.It is of 2 types, method- overloading and overriding
// Two or more methods having same names but different parameters in a class is called method overloading.

class Mol
{
  def Std(id:Int,name:String,address:String): Unit =
  {
    println(id+" "+ name + " "+ address)
  }
  def std(id1:Int,name1:String): Unit =
  {
    println(id1+ " "+ name1)
  }
}
class Moll extends Mol{
  def Std2(): Unit =
  {
    println("The statement is true")
  }

}
object Method_overloading extends App{

  val s= new Moll
  s.Std(1,"Book","nirala nagar")
  s.std(2,"book")
  s.Std2()

}
