package pooja.scala

import org.apache.spark._
object UpperCase {
 
  def convertStr(st : String) : String = {
    st.toUpperCase()
  }
  //passing a function inside a function
  def transformStr(str : String, f: String => String) : String = {
    f(str)
  }
  def main(args : Array[String]) {
    
    //manually passing the value
    println(convertStr("poo"))
    
    //getting user input
    println("Type the string you want to convert: ")
    var input = scala.io.StdIn.readLine()
    println(convertStr(input))
    
    
    var result = transformStr("mom",convertStr)
    println(result)
    
    
  }
}