package programs
// It is used to initialize the instance variables.
// It automatically gets created at the time of execution.
// It is of two types- (a)- primary (b)- Auxilary

// primary Constructor having zero parameters
class Cons()
{
  def con: Unit ={
    println("a")
  }
}
// primary constructors having paramaters
class Cons1(id:Int,first_name:String,Last_name:String)
{
  def cons1(): Unit =
  {
    println(id + " " + first_name + " " + Last_name)
  }
}
object Primary_constructor extends  App{
  val s =new Cons()
  s.con
  val s1=new Cons1(1,"shivam","Tiwari")
  s1.cons1()

}
