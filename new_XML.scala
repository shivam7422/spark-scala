package spark_R

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object new_XML extends App{

  val a= SparkSession.builder().appName("New_XML").master("local").getOrCreate()
  val b= a.read.format("XML").option("rowTag","person")
    .load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\ages.xml")
 // b.printSchema()
 // b.show()
  val c= b.select(col("address.area").as("area"),col("address.pincode").as("pin")
  ,col("age._value").as ("age"),col("age._born").as ("dob")
    ,col("age._birthplace").as ("place"))
val d=  c.na.fill("Domlur",Array("area"))
    .na.fill("0",Array("pin"))
    .na.fill("Sultanpur",Array("place"))
 // d.printSchema()
 // d.show()

  val e= a.read.format("XML").option("rowtag","product").load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\XMLInput.xml")
  val f= e.withColumn("catalog_item",explode(col("catalog_item")))
  //val g= f.withColumn("catalog_item.size",explode(col("size")))
   // .withColumn("color_swatch",explode(col("color_swatch")))

 val g=  f.select(col("_description").as("des"),col("_product_image").as("p_img")
    ,col("catalog_item._gender").as("gender")
    ,col("catalog_item.item_number").as("item_number")
    ,col("catalog_item.price").as("price"),
    col("catalog_item.size._description").as("S_Des")
   ,col("catalog_item.size.color_swatch").as("Value"))

val h= g.withColumn(("S_Des"),explode(col("S_Des")))
    .withColumn("value1",explode(col("Value")))
  val i=h.withColumn(("value1"),explode(col("value1"))).drop("value")

 // i.printSchema()
  //i.show(false)
  val j=  h.select(col("des"),col("p_img")  ,col("gender"),col("item_number")
    ,col("price"),  col("S_Des")  ,col("value1._VALUE").as("Value")
  ,col("value1._image").as("Image"))

  val k=j.withColumn(("Value"),explode(col("Value")))
      .withColumn("Image",explode(col("Image")))
  k.printSchema()
  k.show(100,false)


}
