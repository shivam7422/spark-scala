package spark_R

class AC(id:Int, name:String)
{
  var age:Int=0
  def this(id :Int, name :String,age :Int)
  {
    this (id, name)
    this.age=age

  }
  def showDetails(): Unit =
  {
    println(id + " " + name + " "+ age)

     }
}


object auxilary_Constructor extends App {

  val ob= new AC(1,"shivam",13)
  ob.showDetails()

}
