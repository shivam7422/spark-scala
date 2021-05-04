package Spark

import org.apache.spark.sql.SparkSession

object acc extends App{

  val Spark= SparkSession.builder().appName("CSV_reader").master("local").getOrCreate()

  val e= Spark.read.option("inferschema","true").option("header","true").csv("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\file2.txt")

  val s= Spark.read.format("csv").option("inferschema","true").option("header","true").load("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\file1.txt")

  val c= e.createOrReplaceTempView("tablea")
  val d= s.createOrReplaceTempView("tableb")

  val f= Spark.sqlContext.sql("select * from tablea where (empid,deptid) not in (select a.empid,a.deptid from tablea a, tableb b where b.id=a.deptid)")

  f.show()

}
