package Spark

import org.apache.spark.sql.types.{DoubleType, IntegerType, StructField}
import org.apache.spark.sql.{Row, SparkSession, types}

object Rdd_DF_2 extends App {

  val spark= SparkSession.builder.appName(" RDD- DF-2 format").master("local").getOrCreate()
  val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\sales.csv")
 // a.foreach(println)
  val b= a.filter(e=> !e.startsWith("transactionId"))
  val c= b.map(f=>
    {
      val e= f.split(",")
      Row(e(0).toInt,e(1).toInt,e(2).toInt,e(3).toDouble)
    })
  val sch= types.StructType(Array(
    StructField("transactionId",IntegerType,false),
    StructField ("customerId",IntegerType,false),
    StructField ("itemId",IntegerType,false),
    StructField ("amountPaid",DoubleType,false)
  ))

  val sch1= spark.createDataFrame(c,sch)
  sch1.show()



}
