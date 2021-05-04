package spark_R

class inheritance {

  println("money")
}
class sum extends inheritance
{

  def func(first_name:String,last_name:String,age:Int=20): Any =
  {
    println(first_name + " "+ last_name + " "+ age)

  }

}
object demo extends App
{
  val ob= new sum
  ob.func("shivam","tiwari")
}
