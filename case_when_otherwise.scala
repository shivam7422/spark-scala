package Spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, _}

object case_when_otherwise extends App{

  val spark= SparkSession.builder.appName("case_when_otherwise").master("local").getOrCreate()

  import spark.implicits._
  val data = List(("James","","Smith","36636","M",60000),
    ("Michael","Rose","","40288","M",70000),
    ("Robert","","Williams","42114","",400000),
    ("Maria","Anne","Jones","39192","F",500000),
    ("Jen","Mary","Brown","","F",7660)).toDF("first_name","middle_name","last_name","dob","gender","salary")
  data.show()

  val a= data.withColumn("New_Gender"
    ,when(col("gender")==="M","Male")
    .when(col("gender")==="F" , "Female")
      .otherwise("NA"))
 // a.printSchema()
  a.show()
  val b= a.withColumn("New_salary"
    ,when(col("salary")===60000 || col("salary")===7660,70000)
      .otherwise(0))
  b.show()


}
