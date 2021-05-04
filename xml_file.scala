package Spark

import Spark.Window_Function.simpleData
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object xml_file extends App{

  val spark= SparkSession.builder.appName("xml file").master("local").getOrCreate()
  val x= spark.read.format("xml").option("rowTag","person")

    .load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\ages.xml")
  x.printSchema()

 // x.show()

  val ae= x.select(
    col("address.area").as("area"),col("address.pincode").as ("pin")
    ,col("age._value").as("age"),col("age._birthplace").as("place")
    ,col("age._born").as("dob"))
  ae.show()
// or
  val y= x.createOrReplaceTempView("axis")
  val z= spark.sqlContext.sql("select address.area as area,address.pincode as pin," +
    "age._value as age, age._birthplace as place,age._born as dob,name  from axis")
 // z.show()
  val a= z.na.fill("Not Present",Array("area")).na.fill(0,Array("pin")).na.fill("Not Given",Array("place"))
  a.show()

}
