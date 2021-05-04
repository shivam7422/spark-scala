package Topgear

//Exercise1: Create a function to compute final salary using the following formula.
//   finalSalary = salary * ( 1 + incrementPercent) + bonus
//   where salary, incrementPercent, bonus are input arguments

class Final_sal
{
  def fin_sal (salary:Int)={
    val incrementPercent:Double=.05
    val bonus:Int=5000
    val finalSalary = salary * ( 1 + incrementPercent) + bonus
    print(finalSalary)

  }
}
object To_compute_final_salary extends App {

  val s= new Final_sal
  s.fin_sal(20000)
}
