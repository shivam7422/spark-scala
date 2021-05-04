package Spark

// to add a column we can use WITHCOLUMN function with lit function
// to rename a column we can use WITHCOLUMNRENAMEND function.
// to create a new column with an existing column we can use WITHCOLUMN function
// to add
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructType}
import org.apache.spark.sql.functions.lit

object Add_column extends App {

  val spark= SparkSession.builder.appName("adding a column").master("local").getOrCreate()
  val a= spark.sparkContext.parallelize(Seq(Row(Row("James ","","Smith"),"36636","M","3000"),
    Row(Row("Michael ","Rose",""),"40288","M","4000"),
    Row(Row("Robert ","","Williams"),"42114","M","4000"),
    Row(Row("Maria ","Anne","Jones"),"39192","F","4000"),
    Row(Row("Jen","Mary","Brown"),"","F","5000")))
  val schema = new StructType()
    .add("name",new StructType()
      .add("firstname",StringType)
      .add("middlename",StringType)
      .add("lastname",StringType))
    .add("dob",StringType)
    .add("gender",StringType)
    .add("salary",StringType)
  val e= spark.createDataFrame(a,schema)
  e.printSchema()
 //e.show()

  // to add a column
  val j= e.withColumn("zip",lit(null))
  j.show()
  // to add a column with some value
  val k= e.withColumn("zip",lit("560071"))
  k.show()
  //Using withColumnRenamed – To rename Spark DataFrame column name
  val f= e.withColumnRenamed("dob","Date of birth")
  f.show()

 // Using withColumnRenamed – To rename multiple columns
  val g= e.withColumnRenamed("dob","date of birth")
    .withColumnRenamed("salary","new salary").show()

  val h= e.select(col("name.firstname").as("First_name"),col("name.middlename")
    .as("middle_name"),col("name.lastname").as("last_name"),col("dob")
    ,col("gender"),col("salary"))
    h.show()

 // to create a new column with an existing column
  val i = h.withColumn("New_salary",col("salary")*100)
  i.show()
spark.stop()

}