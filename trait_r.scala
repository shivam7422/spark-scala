package spark_R

trait one
{
  def m1()
}
abstract class two extends one
{
  def m1: Unit ={
    println(" towel")
  }
  def m2()
}
class three extends two
{
  def m2: Unit ={
    println("Paper" )
  }
}


object trait_r extends App {

  val s= new three
  s.m2
  s.m1
}
