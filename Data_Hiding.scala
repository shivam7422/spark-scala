package programs

//Data hiding is hiding the data. When we don't want to give the access of an entity to
//a different one then we can use PRIVATE keyword

class Student
{
 private val balance=500
}
class Teacher
{
  def Tea: Unit =
  {
    val s= new Student
    //println("The balance is " + s.balance)
  }
}

object Data_Hiding extends App{
  val z= new Teacher
  z.Tea
}
