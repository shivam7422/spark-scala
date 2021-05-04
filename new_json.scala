package spark_R

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object new_json extends App {

  val a = SparkSession.builder().appName("new_json").master("local").getOrCreate()
  val b = a.read.json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\movies_en.json")
 // b.printSchema()
  //b.show(false)
  val c = b.withColumn("actors",explode(col("actors")))
  c.printSchema()
  //c.show(false)

  val d=c.select(col("actors.id").as("id"),col("actors.role").as("role"),col("country").as("country")
    ,col("director.first_name").as("DFN"),col("director.id").as("DID"),col("director.last_name").as("DLN"),col("director.year_of_birth").as("DYOB")
    ,col("genre").as("genre"),col("id").as("id"),col("summary").as("summary"),col("title").as("title"),col("year").as("year"))
  d.show()
}