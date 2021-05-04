package spark_R

import spark_R.string_interpolation.s

/*String Interpolation refers to substitution of defined variables or expressions in a given String with respected values.
There are 3 types s,f,and raw
s-> s is used for string, variables, function calls etc.
f-> This interpolation helps in formatting numbers easily.
raw->String Literal should start with ‘raw’. This interpolator treats escape sequences same as
any other character in a String.
*/
class A
{
  def sum: Unit =
  {
    val a=4
    val b=3
    println(s"The sum of $a and $b is ${a+b}")
  }
   def sum4(a:Int,b:Int):Int ={
      a+b
  }


  def sum1: Unit =
  {
    val x=16
    val str2 = f"Value of x is $x%.2f"

    println("str1: " + str2)
  }
  def sum3: Unit =
  {
    val a= "hello \n world!!"
    val b=raw"hello \n world!!"
    println("Without interpolation" +" " + a)
    println ("With interpolation" +" " + b)
  }
}
object string_interpolation extends App{

  val s= new A
  s.sum
  s.sum1
  s.sum3
  val x=10
  val y=20

  val str2 = s"Sum of $x and $y is ${s.sum4(x, y)}"

  println(str2)


}
