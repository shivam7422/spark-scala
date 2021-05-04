package programs

//when we want to execute a group of statements to perform a task that is called a function.

//without parameter

class emp1
{
  def sayHello(): Unit = //without parameter
  {
    println("hello")
  }
  def sayHello(a:String,b:String)//with parameter
  {
    println(a + " " + b)
  }
  def sayHello(a:Int,b:Int): Int = // having return type with parameters
  {
    return a+b
  }
  def sayHello(a:Int,b:Int,c:Int=4) //default parameter, but default parameter should be to the last
  {
    println( a+b+c)
  }
  def func=(a:Int,b:Int)=> println( a+b) // a function which doesn't have any name is called anonymous function

  /* if a functions takes multiple parameters, we can transform into a chain of functions where each  take a
   single parameter called currying functions.*/

  def hello(a:Int)(b:Int)={
   println( a+b)
  }
}
object Functions extends App {

  val s= new emp1
  s.sayHello()
  s.sayHello("shivam","Tiwari")
  println(s.sayHello(1,2))
  println(s.sayHello(1,9))
  s.func(2,3)
  s.hello(4)(5)

  /*high order function-
* it is a function where input will be a function and the output will also be a function.
* */

  def ConvertToLower(s:String)=s.toLowerCase
  def say(a:String,f:(String)=>String)= f(a)

  val e= say("Scala",ConvertToLower)
  print(e)


}
