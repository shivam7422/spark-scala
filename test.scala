package Spark
//scenario 1- jab columns alg alsg na ho
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object test extends App {

  val spark= SparkSession.builder().appName("joins").master("local").enableHiveSupport().getOrCreate()
  val a= spark.read.format("csv").option("inferschema","true").option("header","true")
    .load("src\\main\\resources\\employee_assignment.csv")
  //a.printSchema()
 // a.show()

  val b= spark.read.option("inferschema","true").option("header","true").csv("src\\main\\resources\\123.csv")


  val c= a.where("salary>500").select(col("Employee_ID"),
    col("First_Name"),col("new_col").alias("lname"),col("Department_ID"),col("Salary"))
 // c.show()
  //spark.sql("select * from default.testing").show()
  val d= c.join(b,c("Department_ID")===b("id"),"left").drop("id")
      .withColumn("cntry_cde",lit("TW"))
      .withColumn("biz_cde",lit("GCG"))
      .na.fill("Singh",Array("lname"))
      .na.fill("2021",Array("type"))

 // d.show()

  d.createOrReplaceTempView("temp_table2")

  //spark.sql("drop table default.testing")
  spark.sql("insert overwrite table  default.testing select * from temp_table2")
  spark.sql("select * from default.testing").show()
}
