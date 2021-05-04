package Practice

object question extends App{

  val s=List(1,2,3,5,8,10,13)

  for (i<-1 to s.length-1 ) {
    if(s.indexOf(i)%2==0)
      println("Even Index Number " + s.indexOf(i))
  }
  for (i<-1 until s.length)
    {
      if(s(i)%2==0)
        println(" Even Number " +s(i))
    }

}
