package spark_R

// when an object having same name as class then that object is called CO

class companion_object {

  private val a:String= "towel"

  println(a)
  private def func(b:String):String=
  {

  return b + " K"


  }

}
object companion_object extends App{

  val s= new companion_object
  println(s.func("Sandhya"))
}

