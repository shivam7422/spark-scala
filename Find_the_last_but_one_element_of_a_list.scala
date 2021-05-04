package Practice

// Find the last but one element of a list

class Stu
{
  val s= List(1,2,3,4,5,6,7,8,9)
  val f= s.size  //9
  val e= f-2 //7
  print(s(e))
      //or
  val e1= s.takeRight(2)
  print(e1)// List(8, 9)
  print(e1(0)) //8

}
object Find_the_last_but_one_element_of_a_list extends App {

  val s= new Stu


}
