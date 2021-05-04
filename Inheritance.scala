package programs

// creating a new class from an existing class is called inheritance. We have to use EXTENDS keyword.
// we can't access private variables
// The existing class is called super class and the new class is called child class.

class Stud
{
  def Stu()
  {
    println(" this is a textbook ")
  }
}
class Teac extends Stud
{
  def Tea()
  {
    println(" This is teacher")
  }
}
class app extends  Teac
{
  def sun(First_name:String,Last_name:String): Unit =
  {
    println("My complete name is "+ First_name+" "+ Last_name)

  }
}
object Inheritance extends App{

  val s= new app
  s.sun("shivam","Tiwari")
  s.Stu()
  s.Tea()
}
