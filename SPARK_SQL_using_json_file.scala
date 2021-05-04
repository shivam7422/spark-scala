package Topgear

import org.apache.spark.sql.SparkSession

object SPARK_SQL_using_json_file extends App{

  val spark= SparkSession.builder().appName("json").master("local").getOrCreate()

  val a= spark.read.json("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\top.json")
  a.show()
  a.printSchema()
  //Display only enames from the given file using select.
  val b= a.select("ename")
  b.show()

  //Provide the count of each age.
  a.createOrReplaceTempView("axis")
  val d= spark.sqlContext.sql("select age,count(age) from axis group by age")
  d.show()
  //Display  records whose age <=30.
  val c= spark.sqlContext.sql("select * from axis where age <=30")
  c.show()

}
