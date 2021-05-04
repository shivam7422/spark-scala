package spark_R

import org.apache.spark.sql.SparkSession

object new_rows_to_COlumns extends App{

val spark=SparkSession.builder().appName("rowsToColumns").master("local").getOrCreate()

  import spark.implicits._
  val a= Seq(("NY","New York")).toDF("City","City_name")
  a.printSchema()
  a.show()
  a.createOrReplaceTempView("tab")
  val b= spark.sqlContext.sql("select 'City' as Column , 'City_name' as value from tab union" +
    " select City,City_name from tab")
  b.printSchema()
  b.show()

}
