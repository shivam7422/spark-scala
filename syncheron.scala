package Spark

import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object syncheron extends App{

  val spark= SparkSession.builder().appName("CSV_reader").master("local").getOrCreate()

  import spark.implicits._
  val a= Seq(("abc","3","C",100),
    ("abc","3","C",100),
    ("xyz","4","C",500),
    ("abc","3","D",150),
    ("xyz","4","D",200),
    ("xyz","4","D",200)).toDF("cust","acct","type","amt")
  a.printSchema()
  a.show()

  val b= a.withColumn("credit",when(col("type")==="C",col("amt")).otherwise(0))
   .withColumn("debit",when(col("type")==="D",col("amt")).otherwise(0))
val c= b.groupBy("Cust").sum("credit","debit").orderBy("cust")
  .select(col("cust"),
    (col("sum(credit)").as("credit")-col("sum(debit)").as("debit")).alias("total remaining money"))
  c.printSchema()
  c.show()
  /*val e= spark.read.format("csv").option("inferschema","true").option("header","true").load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\syn.csv")
  e.printSchema()
  e.show()
  e.na.drop().show()*/


}
