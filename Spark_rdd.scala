package Topgear

import org.apache.spark.sql.SparkSession

case class rdd1(Priority:String,qty:Int,sales:Double)
object Spark_rdd extends App{

  val spark= SparkSession.builder().appName("rdd").master("local").getOrCreate()
  //spark.sparkContext.setLogLevel("ERROR")
  val s= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\training.txt",3)
 s.foreach(println)
  println(s.getNumPartitions)


}
