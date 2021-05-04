package Topgear

import org.apache.spark.sql.SparkSession

object json_json extends App {

  val spark= SparkSession.builder().appName("rdd").master("local").getOrCreate()
  val s= spark.read.json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\json.json")
 // val g= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\json.json")
  //g.foreach(println)
  //s.printSchema()
  //s.show()

  val g= spark.read.format("xml").load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\ages.xml")
    .show()
}
