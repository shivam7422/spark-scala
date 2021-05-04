package Spark

import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object atos extends App{


  val spark= SparkSession.builder().appName("CSV_reader").master("local").enableHiveSupport().getOrCreate()
  val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\atos.txt")
 // a.foreach(println)
  val b= a.flatMap(x=>x.split(" "))
  val c= b.groupBy(w=>w)
  val d= c.map(t=>(t._1,t._2.size))
  //d.foreach(println)

  import spark.implicits._
  val e= d.toDF("name","count")
  //e.printSchema()
 // e.show(100,false)
 //e.createOrReplaceTempView("temp_table")
 // val f= spark.sql("select * from temp_table order by count desc limit 5")
  //val g= f.drop("count").show()

  e.orderBy(desc("count")).limit(5).show()


}
