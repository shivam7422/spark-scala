package Topgear
//      incrementPercent = 0.05
//      bonus = 5000
class changes_to_first {
  def fin_sal (salary:Int)={
    val incrementPercent:Double=.05
    val bonus:Int=5000
    val finalSalary = salary * ( 1 + incrementPercent) + bonus
    print(finalSalary)

  }
}
object changes_to_first extends App {

  val s= new Final_sal
  s.fin_sal(20000)

}
