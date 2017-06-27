package pooja.scala
import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._


object CustomerAmount {
  
  def parseLine(line : String ) = {
    val field = line.split(",")
    val customerID = field(0).toInt
    val amountSpent = field(2).toFloat
    (customerID, amountSpent)
  }
  
  def main(args : Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","CustomerAmount")
    val input = sc.textFile("..//customer-orders.csv")
    val customerDetails = input.map(parseLine)
    val customerAmount = customerDetails.reduceByKey((x,y)=>x+y)
    val results = customerAmount.collect()
    results.foreach(println)
    
    
    
  }
}