package pooja.scala

import org.apache.spark._
object FibonacciSeries {
  def main(args: Array[String]) {
    
    var count : Int = 0
    var n1 : Int = 0
    var n2 : Int = 1
    var n3 : Int = 0 
    println(s"$n1")
    println(s"$n2")
    while (count <= 8)
    {
     n3 = n1 + n2
     n1 = n2
     n2 = n3
     count += 1
     println(s"$n3") 
    }
  }
}