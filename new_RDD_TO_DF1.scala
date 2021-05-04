package spark_R

import org.apache.spark.sql.SparkSession

case class customers(customerId:Int,customerName:String)
object new_RDD_TO_DF1 extends App{

  val spark= SparkSession.builder().appName("new_RDD_TO_DF1").master("local").getOrCreate()
  val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\customers.csv")
 val b= a.filter(e=> !e.startsWith("customerId"))
  import spark.implicits._
  val c= b.map(e=>{ val w= e.split(",")
  customers(w(0).toInt,w(1).toString)}).toDF()

  c.printSchema()
  c.show()
  c.createOrReplaceTempView("axis")
  //val d= spark.sqlContext.sql("select sum(customerId) as tot from axis")
 // d.show()
 val e= c.groupBy().sum("customerId").withColumnRenamed("sum(customerId)","tot1").show()




}
