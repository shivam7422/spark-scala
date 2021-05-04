package spark_R

class mol {
  def sum(id:Int,name:String,age:Int): Unit =
  {
    println(id+ " " + name + " "+ age)

  }
  def sum(id:Int,name: String, age:Int, city:String)=
  {
    println(id+ " " + name + " "+ age + " "+ city)
  }
}
class mol2 extends mol
{
  def demo1: Unit =
  {
    println("hello")
  }
}

object method_overloading extends App {

  val m1= new mol2
  m1.sum(1,"shivam",21)
  m1.sum(2,"towel",22,"kadipur")
  m1.demo1

}
