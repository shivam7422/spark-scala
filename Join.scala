package Spark

import org.apache.spark.sql.SparkSession

object Join extends App {

  val spark= SparkSession.builder().appName("joins").master("local")
    //.config("spark.sql.join.preferSortMergeJoin", "true")
    .getOrCreate()
  val a= spark.read.option("inferschema","true").option("header","true").csv("src\\main\\resources\\customers.csv")
  a.show()
  val b= spark.read.option("inferschema","true").option("header","true").csv("src\\main\\resources\\sales.csv")
  b.show()
  println("inner join")

 val c= a.join(b,a("customerId")===b("customerId")).sort(a("customerId").asc)
   c.show(false)

  //println("left join")
  //a.join(b,a("customerId")===b("customerId"),"left").sort(a("customerId").asc).show()

  c.explain()



}
