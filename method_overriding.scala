package spark_R

class mor
{
  def cls(id:Int,name:String): Unit =
  {
    println( id + name)
  }
}
class mor1 extends mor
{
  override def cls(id:Int,name:String): Unit =
  {
    println(id)
  }
}

object method_overriding extends App
{
  val m= new mor1
  m.cls(1,"kadipur")

}
