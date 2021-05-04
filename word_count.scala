package spark_R

import org.apache.spark.sql.SparkSession

object word_count {

  def main(args: Array[String]): Unit = {

    val spark= SparkSession.builder().appName("word count").master("local").getOrCreate()

    val a= spark.sparkContext.textFile("C:\\Users\\Shiva\\IdeaProjects\\new_one\\src\\main\\resources\\abc.txt")
    //a.foreach(println)
    val b = a.flatMap(x=>x.split(" "))
   // b.foreach(println)
    val c= b.groupBy(w=>w)
  //  c.foreach(println)
    val d= c.map(x=>(x._1,x._2.size))
    //d.foreach(println)
    import spark.implicits._
    val e= d.toDF("name","Count")
    e.show()


  }

}
