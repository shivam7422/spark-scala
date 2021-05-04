package programs

case class staff(id:Int)
class Cclass_Nclass (id:Int)

object demo extends App
{
  val s= new staff(1)
  val s1= new staff(1)
  val s2= new Cclass_Nclass(2)
  val s3= new Cclass_Nclass(2)

  val s5= s==s1
  val s4= s2==s3
  println(s"case class : $s5")
  println(s"normal case: $s4")
}
