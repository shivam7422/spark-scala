package spark_R

import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.functions._

object wordcount_dataframe extends App {

  val spark=SparkSession.builder().appName("wc_DF").master("local").getOrCreate()

  import spark.implicits._

  val a= spark.read.format("text").load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\123.txt").toDF("word1")

  //a.show(false)

  val b= a.withColumn("word",explode(split(col("word1")," "))).select(col("word"))

   val e=b.groupBy("word").count()

  e.show()

  println("second Type")

  val c= spark.read.format("text").load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\1234.txt").toDF("word1")

  val d= c.groupBy("word1").count()

    d.show()

}
