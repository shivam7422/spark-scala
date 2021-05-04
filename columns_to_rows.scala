package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object columns_to_rows extends App {

  val spark= SparkSession.builder().appName(" Columns to rows").master("local").getOrCreate()

  import spark.implicits._
  val states = Seq(("NY","New York")).toDF("cty_code","City_Name")
  states.printSchema()
  states.show()
  val a= states.createOrReplaceTempView("axis")
  val b= spark.sqlContext.sql(
    "select 'Cty_code' as column,Cty_code as value from axis union " +
      "select 'City_Name',City_Name  from axis ")
  b.show()


}
