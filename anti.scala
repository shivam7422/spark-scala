package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql._

object anti extends App {

  val spark= SparkSession.builder.appName("rows to columns").master("local").getOrCreate()
  val ss= spark.read.option("inferschema","true").option("header","true")
    .csv("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\sales1.csv")
  ss.printSchema()
  ss.show()
  ss.groupBy("id")



}
