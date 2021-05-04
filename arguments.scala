package Spark

import org.apache.spark.sql.Column
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{add_months, col, date_add, date_sub}

object arguments extends App{

  val spark= SparkSession.builder().appName("CSV_reader").master("local").getOrCreate()
  println("The arguments are mentioned below  ->")
  println("First argument is => "+ args(0))
  println("Second argument is => "+ args(1))
  println("Third argument is => " + args(2))
  import spark.implicits._
  val a= Seq(("2019-01-23"),("2019-06-24"),("2019-09-20")).toDF("input")
    .select( col("input"),
      add_months(col("input"),3).as("add_months"),
      add_months(col("input"),-3).as("sub_months"),
      date_add(col("input"),4).as("date_add"),
      date_sub(col("input"),4).as("date_sub")
    )
  val b: Column= a.col("input")===args(3) || a.col("input")===args(4)

  val c= a.where(b)
  c.createOrReplaceTempView("Temp_table")
 val d= spark.sql("select * from temp_table")
  val e= d.col("add_months")===args(5)
  d.where(e).show();


// spark command to run from CMD.
//spark-submit  --class Spark.arguments new_one_2.12-0.1.jar 1 2 3 2019-01-23 2019-09-20
  //spark-submit  --class Spark.arguments new_one_2.12-0.1.jar 1 2 3 2019-01-23 2019-09-20 2019-04-23

}
