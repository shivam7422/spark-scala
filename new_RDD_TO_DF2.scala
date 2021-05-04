package spark_R

import org.apache.spark.sql.{Row, SparkSession, types}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object new_RDD_TO_DF2 extends App{

  val spark= SparkSession.builder().appName("new_RDD_TO_DF1").master("local").getOrCreate()
  val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\customers.csv")
val c= a.filter(e=> !e.startsWith("customerId"))
  //c.foreach(println)
  val d= c.map(e=>
  {
    val w= e.split(",")
    Row(w(0).toInt,w(1).toString)
  })

  val sch= types.StructType(Array(
    StructField("Customerid",IntegerType,false),
    StructField("CustomerName",StringType,false)
  ))
    val df= spark.createDataFrame(d,sch)
  df.printSchema()
  df.show()


}
