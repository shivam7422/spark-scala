package programs

// Based on requirement we can create more than one constructor in a class
// By using THIS, we can create Auxiliary constructors.
// By using this keyword, we can call the constructor from one to another.
class Auxc(id:Int,name:String, address:String, age:Int)
{
  def this(id:Int,name:String, address:String)
  {
    this(id,name,address,34)
    println("my id is "+id+". My name is "+name+", my adreess is "+address+" and my age is 34")
  }
  def this(id:Int, age:Int)
  {
    this(id,"yoyo","china",age)
    println("my id is "+id+". My name is yoyo, my adreess is china and my age is "+age)
  }
}
object Auxilary_constructor extends App{
  //val s= new Auxc(1,"Shivam Tiwari","blr",27)
  val ws= new Auxc(2,"sunny Tiwari","kol")
  val sq= new Auxc(3,"ankit Tiwari","assam")
  val sqq= new Auxc(4,"akhil Tiwari","eden")
  val sqqq= new Auxc(5,"satyam Tiwari","london")
  val wew=new Auxc(6,23)
//  s.show()


}
