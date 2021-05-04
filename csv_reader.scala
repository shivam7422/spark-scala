package Spark

import org.apache.spark.sql._


object csv_reader extends App{

  System.setProperty("hadoop.home.dir", "C:\\hadoop-2.7.2\\bin\\winutil\\")

  val Spark= SparkSession.builder().appName("CSV_reader").master("local").getOrCreate()
  val s= Spark.read.option("inferschema","true").option("header","true")
      .csv("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\123.csv")
  s.printSchema()

  //s.show()
  val g= s.na.fill(0,Array("population"))
    .na.fill("Unknown",Array("City"))
    .na.fill("NonUnique",Array("type"))

 val f= g.select("id","zipcode","type","city","state","population").where("population =0 or population>3700")
  val h= g.select("state","zipcode").groupBy("state","zipcode").count()
 // h.show()
  //Thread.sleep(10)
}