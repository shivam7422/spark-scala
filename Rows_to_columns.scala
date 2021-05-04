package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object Rows_to_columns extends App{

  val spark= SparkSession.builder.appName("rows to columns").master("local").getOrCreate()
  import spark.implicits._
  val a= spark.sparkContext.parallelize(Seq(("Banana",1000,"USA"), ("Carrots",1500,"USA"), ("Beans",1600,"USA"),
    ("Orange",2000,"USA"),("Orange",2000,"USA"),("Banana",400,"China"),
    ("Carrots",1200,"China"),("Beans",1500,"China"),("Orange",4000,"China"),
    ("Banana",2000,"Canada"),("Carrots",2000,"Canada"),("Beans",2000,"Mexico"))).toDF("Orders","Price","Country")
 a.show()
  val b= a.select(col("Orders"),map(col("Country"),col("Price")).as("gp"))
 // b.show()
  val c= b.createOrReplaceTempView("axis")
  val d= spark.sqlContext.sql("select orders, collect_List(gp['USA'])[0] as USA," +
    "collect_List(gp['China'])[0] as China," +
    "collect_List(gp['Canada'])[0] as Canada," +
    "collect_List(gp['Mexico'])[0] as Mexico from axis group by orders")
  d.show()
  val e= d.na.fill(0,Array("Canada")).na.fill(1,Array("Mexico"))
  e.show()
  // to add a new column
  val f= e.withColumn("Country",lit("")).show()
}
