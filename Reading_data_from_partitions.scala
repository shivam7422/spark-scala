package Spark

import org.apache.spark.sql.SparkSession

object Reading_data_from_partitions extends App {

  val spark= SparkSession.builder.appName(" Reading data from partitions").master("local").getOrCreate()
  val a= spark.sparkContext.parallelize(Seq(("Banana",1000,"USA"), ("Carrots",1500,"USA"), ("Beans",1600,"USA"),
    ("Orange",2000,"USA"),("Orange",2000,"USA"),("Banana",400,"China"),
    ("Carrots",1200,"China"),("Beans",1500,"China"),("Orange",4000,"China"),
    ("Banana",2000,"Canada"),("Carrots",2000,"Canada"),("Beans",2000,"Mexico")),3)
  a.foreach(println)
  println(" number of partitions "+ a.getNumPartitions)

  val b= a.mapPartitionsWithIndex((idx,itr)=>if(idx==1) itr else Iterator())
  b.foreach(println)
  val c= a.repartition(6)
  println(" number of partitions "+ c.getNumPartitions)

  val d= c.mapPartitionsWithIndex((idx,itr)=>if(idx==0) itr else Iterator())
  d.foreach(println)
  val e= c.coalesce(4)
  println(e.getNumPartitions)
}
