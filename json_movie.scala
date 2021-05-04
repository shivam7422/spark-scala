package Topgear
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window

object json_movie extends App {

  val spark = SparkSession.builder.appName("rows to columns").master("local").getOrCreate()
  val json_mov = spark.read.json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\movies_en.json")
  json_mov.printSchema()
  json_mov.show(2, false)
  val json_art = spark.read.json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\artists_en.json")
  json_art.printSchema()
  json_art.show(2)
  //b.	Write a query to group titles of American movies by year

  val e=json_mov.withColumn("colD", collect_list("title").over(Window.partitionBy("year")
    .orderBy("year"))).select("year","colD").distinct()
  json_mov.write.mode("overwrite").parquet("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res2")
  json_art.write.mode("overwrite").parquet("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res3")
  val w= json_mov.withColumn("actors",explode(col("actors")))
  //Stores link between Movie, Artist and Role played
  val q= w.select("actors.id","actors.role","title")
  //
  //



}
