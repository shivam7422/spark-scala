package spark_R

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.lit


object New_one extends App{

  val a= SparkSession.builder().appName("New_one").master("local").getOrCreate()
  val b= a.read.format("csv").option("inferschema","true").option("header","true")
  .load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\123.csv")
  b.show()
  val c= b.withColumn("zip",lit(null))
  val d= c.withColumnRenamed("zip","zipppy")
  d.printSchema()
  val e= d.withColumn("zipppy",col("zipcode")*100)
  val f= e.na.fill(0,Array("population")).na.fill("AWESOME",Array("type"))
  f.show()


}
