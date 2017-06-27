package pooja.scala

import org.apache.spark._
object ListExample {
  
    
  def main(args : Array[String]) {
    
    val numberList = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    //using map function to check if every number in the list is divisble by 3
    val resultmap = numberList.map((x : Int) => {
      if ( x%3 == 0){
        println(x)
      }
    })
    
    //now using filter function to do the same
    val divisiblebythree = numberList.filter((x:Int) => x%3 == 0)
    println(divisiblebythree)
  
}
}
