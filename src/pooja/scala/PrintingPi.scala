package pooja.scala

import org.apache.spark._
object PrintingPi {
  def main(args: Array[String]) 
  {
  val pi : Double = 3.14159265f
  val doubledpi : Double = pi * 2
  println(f"doubled value of pi is $doubledpi%.3f")
  }
}