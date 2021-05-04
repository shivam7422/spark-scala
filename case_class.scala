package spark_R

case class anti(id:Int, name:String)
{
  println("The id is   " + id)
  println("The id is   " + name)

}
object case_class extends App{

  val s= new anti(1,"shivam")

}
