package Topgear

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.functions.collect_set
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.concat_ws

object locaton_wise_experience extends App {

  val spark = SparkSession.builder.appName("location wise experience").master("local").getOrCreate()
  val a= spark.read.option("inferschema","true").option("header","true").csv("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\userinfo.csv")
  val b= spark.read.option("inferschema","true").option("header","true").csv("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\usertransactions.csv")

  //Find the number and list of unique locations in which each product has been sold.
   a.printSchema()
  b.printSchema()

  val c= a.join(b,Seq("userID"),"inner").distinct()

  val d= c.select("productID","location").distinct()
  val e= d.withColumn("LocationLst",collect_set("Location").over(Window.partitionBy("ProductID").orderBy(col("ProductID").asc))).select("ProductID","LocationLst")
 e.createOrReplaceTempView("axis")
  val g= spark.sqlContext.sql("select distinct productID, size(LocationLst) as NumLocations,concat_ws(':',LocationLst) as LocationLst from axis")
  //g.show(false)

 // Find the Top 3 locations by Sales. Store the output as a json file.

   c.createOrReplaceTempView("axis")
  val f= spark.sql("select location,sum(PurchaseAmt) as Sales,dense_rank()over(order by sum(PurchaseAmt) desc)as Rank from axis group by location")
  val h= f.where("rank=1 or rank=2 or rank=3")
  h.show()
  h.write.mode("overwrite").json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res")

  //Find the location wise user summary. Store the output as a parquet file.
  val i= spark.sql("select distinct location,count(userID) as Number_Of_Users,count(TransactionID) as NumTransactions,sum(purchaseAmt)as Total_Amount from axis group by location")
  i.show()


}
