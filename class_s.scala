package programs

/* A class is a plan/theory of properties of actions and objects.
it contains only 3 things-
constructor- to initialize variables
variables- is used to represent data
Methods- to perform operations
*/

class Emp
{
  val id:Int=10
  val name:String="shivam"
  def details(): Unit =
  {
    println(f"the id is $id")
    println(f"the name is $name")
  }
}

class Em_p(id:Int,name:String)
{
  def details1(): Unit =
  {
    println(f" the 2nd id is $id")
    println(f" the 2nd name is $name")
  }
}

class Emp3
{
  val s="Tiwari"
  def func1(a:String):String=
  {

    return a + " " + s
  }
}

object class_s extends App {

 val ob= new Emp
 val oc= new Em_p(1,"Tiwari")
  val od= new Emp3
   println(od.func1("shivam"))
  ob.details()
  oc.details1


}
