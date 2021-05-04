package Spark

import Spark.test.{b, c}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object reporting_sec2 extends App{

  val spark= SparkSession.builder().appName("joins").master("local").enableHiveSupport().getOrCreate()
  val a= spark.read.format("csv").option("inferschema","true").option("header","true")
    .load("src\\main\\resources\\employee_assignment.csv")
  //a.printSchema()
  // a.show()

  val b= spark.read.option("inferschema","true").option("header","true").csv("src\\main\\resources\\123.csv")
  // .select(col("id"),col("zipcode"),col("population"))

  val c= a.where("salary>500").select(col("Employee_ID"),
    col("First_Name"),col("new_col").alias("lname"),col("Department_ID"),col("Salary"))

  val d= c.join(b,c("Department_ID")===b("id"),"left").drop("id")
    .select(col("state"),col("Employee_ID"),col("First_Name"),col("lname")
      ,col("Department_ID"),col("Salary"),col("zipcode"),col("type"),
      col("city"),col("population"))
    .withColumn("cntry_cde",lit("TW"))
    .withColumn("biz_cde",lit("GCG"))
    .na.fill("Singh",Array("lname"))
    .na.fill("2021",Array("type"))

  d.createOrReplaceTempView("temp_table")
 spark.sql("insert overwrite table default.testing_sec2 select * from temp_table")
  spark.sql("select * from default.testing_sec2 ").show()
  val e= d.select(concat_ws(" ",col("First_Name"),col("lname")).as("name"))
  e.show()

  val f= e.select(col("name"),substring(col("name"),-3,2))
  f.show()

  import spark.implicits._
  val g= Seq("abcdefghijklmnopqrstuvwxyz").toDF()
  g.show(false)
  val h= g.select(col("value"),substring(col("value"),- 15,16))
 //val h= g.select(substring(col("value"),length(col("value"))))
  g.createOrReplaceTempView("team")
  spark.sql("select value, substr(value,length(value)-14) as substr from team").show(false)
  h.show(false)

}
