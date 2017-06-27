package pooja.scala
import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object MajorContent {
    
   def main(args : Array[String]) {
    val stopWords = List("the","u","j","e","no","ve","ll","all","just","so","own","out","there","how","from","them","up","an","about","not","do","re","my","at","what","will","they","but","time","or","this","t","with","have","as","be","can","i","s","if","are","on","for","is","in","it","that","and","of","a","your","to","you")
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local", "WordCountBetterSorted")
    val input = sc.textFile("../book.txt")
    
    val words = input.flatMap(x => x.split("\\W+"))
    val lowercaseWords = words.map(x => x.toLowerCase())
    
    val filtering = lowercaseWords.filter(!stopWords.contains(_))
    val wordCounts = filtering.map(x => (x, 1)).reduceByKey( (x,y) => x + y )
    val wordCountsSorted = wordCounts.map( x => (x._2, x._1) ).sortByKey()
    for (result <- wordCountsSorted) {
      val count = result._1
      val word = result._2
      println(s"$word: $count")
    }
  }
  
}