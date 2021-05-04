package Topgear
//Exercise5: In the above employee class, create an auxiliary constructor
// which allows creating employee instances with no location assigned.

class Employee1(empID:String,empName:String,location:String,salary:Int)
{
  def getEMpname
  {
    println("empid = " +empID)
  }
  def incrementSalary
  {
    val salIncPct= salary+100
    print("Increment salary = " + salIncPct)
  }
  def this(empID:String,empName:String,salary:Int)
  {
    this(empID,empName,"blr",salary)
  }

}
object auxilary_class  extends App{

  val s=new Employee1("121","Ram",7676)
  s.getEMpname
  s.incrementSalary


}
