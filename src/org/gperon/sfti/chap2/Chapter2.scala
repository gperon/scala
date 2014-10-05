/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gperon.sfti.chap2

object Chapter2 {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println("Chapter 2: Control Structures and Functions")
    println("Exercise 1 -10=" + exercise1(-10) + " 0=" + exercise1(0) + " 33=" + exercise1(33))
    println("Exercise 4 " + exercise4)
    println("Exercise 5 " + exercise5(20))
    println("Exercise 6 " + exercise6("Hello"))
    println("Exercise 7 " + exercise7("Hello") + " " + exercise7_bis("Hello"))
    println("Exercise 8 " + exercise8("Hello") + " :)")
    println("Exercise 9 " + exercise9("Hello"))
    println("Exercise 10  3^-5=" + exercise10(3,-5) + " 3^12=" + exercise10(3,12) + " 3^7=" + exercise10(3,7))
    
  }
  
  def exercise1 (n : Int) : Int = {
    if (n == 0) 0 else {if (n<0) -1 else 1}
  }
  
  def exercise4 : String = {
    var i = 10
    var s =""
    while (i>=0) {
      s=s+" " +i
      i=i-1
    }
    s
  }
  
  def exercise5 (n : Int) : String = {
    countdown(n)
  }
 
  def countdown (n: Int) : String = {
    var i = n
    var s =""
    while (i>=0) {
      s=s+" " +i
      i=i-1
    }
    s
  }
  def exercise6 (s: String) : Long = {
    var i = 1L
    for (c <- s) i *= c
    i
  }
  def exercise9 (s: String) : Long = {
    if (s.isEmpty) 1L else 1L * s.head *   exercise9(s.tail) 
  }
  def exercise7 (s: String) : Long = {
    s.map(_.toLong).product 
  }
  def exercise7_bis (s: String) : Long = {
    s.foldLeft(1L)(_ * _.toLong)
  }
  def exercise8 (s: String) : Long = {
    exercise7(s)
  }
  def exercise10 (x : Double, n:BigInt) : Double = {
    if (n==0) 1 else {
      if (n<0) 1/exercise10(x,-n) else {
        if (n.mod(2)==0) Math.pow(exercise10(x, n/2),2) else x*exercise10(x,n-1)
      }
    }
    
  }
}
