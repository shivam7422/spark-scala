package Spark

import org.apache.spark.sql.SparkSession

object BroadCast_Variable extends App{

  val spark= SparkSession.builder.appName("Broadcast Variable").master("local").getOrCreate()
  val states = Map(("NY","New York"),("CA","California"),("FL","Florida"))
  val countries = Map(("USA","United States of America"),("IN","India"))

  val broadCast_states= spark.sparkContext.broadcast(states)
  val broadCast_countries= spark.sparkContext.broadcast(countries)

import spark.implicits._
  val data = Seq(("James","Smith","USA","CA"),
    ("Michael","Rose","USA","NY"),
    ("Robert","Williams","USA","CA"),
    ("Maria","Jones","USA","FL")
  ).toDF("firstname","lastname","country","state")

  val e= data.map(f=>
  {
    val countries= f.getString(2)
    val state= f.getString(3)

    val full_country= broadCast_countries.value.get(countries).get
    val full_states= broadCast_states.value.get(state).get
    (f.getString(0),f.getString(1),full_country,full_states)
  }).toDF("firstname","lastname","country","state")

  e.printSchema()
  e.show(false)
}