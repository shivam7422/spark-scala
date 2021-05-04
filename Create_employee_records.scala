package Topgear
//Exercise4:  Create a employee class to create employee records using following class variables and methods:
//   Variables:
//      empID String
//      empName String
//      location String
//      salary Int
//   Methods:
//      getEmpName(empID)
//      incrementSalary(empID, salIncPct)  ->> returns salary post increment
//   Create a default constructor to generate employee records with all 4 variables.

class Employee(empID:String,empName:String,location:String,salary:Int)
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
}

object Create_employee_records extends App{

  val s= new Employee("123","Ram","blr",25000)

  s.getEMpname
  s.incrementSalary
}
