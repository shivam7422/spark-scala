package spark_R

class ant {

  def func(x:Int)(implicit y:Int)=x*y
  implicit val z=10
  println("With implicit function " +" "+ func(3))
  println("Without implicit function " +" "+ func(3)(4))

  val mms:String="Hello"
  def display(implicit  msg:String)= mms +" " + msg
  implicit  val zi="World!!"
  println("With implicit function " +" "+display)
  println("Without implicit function " +" "+display("India"))

}
object implicits extends  App{

  val s= new ant
  //s.disp("India")

}

