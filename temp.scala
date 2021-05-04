package spark_R

import org.apache.spark.sql.SparkSession

object temp extends App {

  val spark=SparkSession.builder().appName("Temp").master("local").getOrCreate()

  val a= spark.read.format("csv").option("inferschema","true").option("header","true")
    .load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\123.csv")
  a.printSchema();a.show()

   a.write.mode("overwrite").parquet("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res_par1\\temp.parquet")
  println("-----------------------")
  val c= spark.read.parquet("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\res_par1\\temp.parquet\\*").show()
  val b= spark.sparkContext.longAccumulator("Addition")
  spark.sparkContext.parallelize(Array(1,2,3,4)).foreach(x=>b.add(x))
  println(s"the value will be ${b.value}")

}
