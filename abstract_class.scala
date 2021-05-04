package spark_R

abstract class acc {

  def one (id:Int): Unit =
  {
    println(id)
  }
  def two()
  def three (name:String): Unit =
  {
    println(name)
  }

}
class acc1 extends acc{
  def two: Unit =
  {
    println("two")
  }
}


object abstract_class extends App{

  val a= new acc1
  a.one(1)
  a.two
  a.three("Kadipur")

}
