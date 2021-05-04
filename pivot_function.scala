package Spark

import org.apache.spark.sql.SparkSession

object pivot_function extends App {
  val spark= SparkSession.builder().appName("converting rows to columns ").master("local").getOrCreate()
  import spark.implicits._
  val data = Seq(("Banana",1000,"USA"), ("Carrots",1500,"USA"), ("Beans",1600,"USA"),
    ("Orange",2000,"USA"),("Orange",2000,"USA"),("Banana",400,"China"),
    ("Carrots",1200,"China"),("Beans",1500,"China"),("Orange",4000,"China"),
    ("Banana",2000,"Canada"),("Carrots",2000,"Canada"),("Beans",2000,"Mexico")).toDF("Products","Money","Country")
  data.printSchema()
  data.show()
  val a= data.groupBy("Products").pivot("Country").sum("Money")
  a.show()

  //unpivot

  val b=a.selectExpr("Products",
    "stack(4,'canada',canada,'China',china,'Mexico',Mexico,'USA',USA)")
    .withColumnRenamed("col0","Country")
      .withColumnRenamed("col1","Money")
      .where("Money is not null")

  b.show()
}
