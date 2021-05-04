package Spark

import org.apache.spark.sql.SparkSession

case class customers(customerId:Int,customerName:String)
object Rdd_to_DF_1 extends App {

  val spark= SparkSession.builder().appName(" Rdd to DF").master("local").getOrCreate()
  val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\customers.csv")
  //a.foreach(println)
  val b= a.filter(e=> !e.startsWith("customerId"))
 // b.foreach(println)
  import spark.implicits._
  val c= b.map(e=>
  {
    val w= e.split(",")
    customers(w(0).toInt,w(1).toString)
  }).toDF()
  c.printSchema()
  c.show()

}
