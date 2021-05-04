package Topgear

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
case class log_file(date:String,time:String,size:Int,r_version:String,r_arch:String,r_os:String,pckage:String,
version:String, country:String,ip_id:Int)
object spark_l2 extends App{

  val spark= SparkSession.builder().appName("spark sql").master("local").getOrCreate()
  val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\log_file.csv")
//  a.foreach(println)
  val b= a.filter(e=> !e.startsWith("date"))
  //b.foreach(println)
  import spark.implicits._
  val c= b.map(e=>
  {
    val fin= e.split(",")
    log_file(fin(0).toString,fin(1).toString,fin(2).toInt,fin(3).toString,fin(4).toString,fin(5).toString,fin(6).toString,
      fin(7).toString,fin(8).toString,fin(9).toInt)
  }).toDF()
  c.printSchema()
  //c.show(5,false)

  //b.	Filter out records where package = “NA” and version = “NA”
 val e= c.select("date","time","size","r_version","r_arch","r_os","pckage","version","country","ip_id").where("pckage='NA'and version = 'NA'")
 // e.show()
  //c.	Find total number of downloads for each package
  val d= c.groupBy("pckage").sum("size").withColumnRenamed("sum(size)","Downloads")
  //d.show()
  //	Find Average download size for each Country
  val f= c.groupBy("country").avg("size")
 // f.show()
  val g= c.withColumn("Hash Column",struct($"country",$"pckage")).select("Hash Column")
  g.show()
  //g.write.mode("overwrite").json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res_json")
  val h= c.withColumn("Download_Type",when(col("size")<100000,"Small")
  .when(col("size") > 100000 && col("Size") < 1000000,"Medium")
  .otherwise("Large"))
  //h.show()
  //d.	Find the total number of Downloads by Country and Download Type

  val i= h.groupBy("country","Download_Type").sum("Size").withColumnRenamed("sum(size)","Total_size")
  i.show()
  //i.write.mode("overwrite").parquet("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res_par")
  val j= spark.read.json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res_json1")
  j.show()
  val k = j.groupBy("date").count()
 // k.show()

  // c.	Find Max, Min and Average Download Size for each Date

  val l= c.groupBy("date").agg(max("size"),min("size") ,avg("size"))
  l.show()
  val m= l.orderBy(col("date").asc)
  //m.show()
  m.write.mode("overwrite").json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res_json")
}