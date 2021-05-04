package Spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions._

object Window_Function extends App{

  val s= SparkSession.builder().appName(" windows Function").master("local").getOrCreate()
  import s.implicits._
  val simpleData = Seq(("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100)).toDF("employee_name", "department", "salary")
  //simpleData.printSchema()
  simpleData.show()

  val windowSpec  = Window.partitionBy("department").orderBy("salary")

  //Ranking Function
  val a= simpleData.select(
    col("employee_name"),col("department"),col("salary")
    ,row_number().over(windowSpec).as("row_number")
    ,dense_rank().over(windowSpec).as("dense_rank")
    ,rank().over(windowSpec).as("rank")
  )
    a.show()

  //Aggregate Function

  val wq= Window.partitionBy("department")
  val b= simpleData
    .withColumn("avg",avg(col("salary")).over(wq))
    .withColumn("max",max(col("salary")).over(wq))
    .withColumn("min",min(col("salary")).over(wq))
    .withColumn("sum",sum(col("salary")).over(wq))
    .select("department","avg","sum","min","max").distinct()
  b.show()
  val c=simpleData.groupBy("department").min("salary").withColumnRenamed("min(salary)","min(sal)")
    c.show()
}
