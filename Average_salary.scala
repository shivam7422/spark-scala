package Topgear
//Exercise3: Store the following list of values using appropriate collections.
//   EmpName,Loc,Salary
//   Ramesh,BDC,55000
//   Janaki,CDC,45000
//   Kailash,BDC,60000
//   Lijo,CDC,51000
//   Create a function which accepts the collection as input and returns average salary
class Fin_sal{
  val a= ("Ramesh","BDC",55000)
  val b= ("Janaki","CDC",45000)
  val c= ("Kailash","BDC",60000)
  val d=  ("Lijo","CDC",51000)

  val e= (a._3 + b._3 + c._3 + d._3)/4
  print("Average Salary = " +e)
}

object Average_salary extends App {
  val s= new Fin_sal
}
