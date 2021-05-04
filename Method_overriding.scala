package programs

// Two or more methods having same names and same parameters in a class is called method riding.
// We have to use OVERRIDE keyword if we don't like the implementation of the parent class
// If we are using constructor in a function then we can't override that.

class MOOR
{
  def stu(id:Int,First_name:String,last_name:String): Unit =
  {
    println(id +" "+ First_name + " "+ last_name)
  }
  def stu1: Unit =
  {
    println(" This is it")
  }
}
class MOORe extends MOOR
{
   def stu(id:Int,First_name:String,age:Int): Unit =
  {
    println(id+" "+ First_name)
  }
  override def stu1: Unit =
  {
    println("yoyo")
  }
}

object Method_overriding  extends  App{

  val s= new MOORe
  s.stu(1,"shivam","Tiwari")
  s.stu1

}
