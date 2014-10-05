/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gperon.sfti.chap1
import scala.math.BigInt._
import scala.util.Random

object Chapter1 {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println("Chapter 1: The Basics")
    println("Exercise 1 Answer = " + exercise1)
    println("Exercise 2 Answer = " + exercise2(3))
    println("Exercise 3 Answer = " + exercise3)
    println("Exercise 4 Answer = " + exercise4)
    println("Exercise 5 Answer = " + exercise5)
    println("Exercise 6 Answer = " + exercise6)
    println("Exercise 7 Answer = " + exercise7)
    println("Exercise 8 Answer = " + exercise8)
    println("Exercise 9 Answer = " + exercise9("camel"))
    println("Exercise 10 Answer = " + exercise10("camel"))
    
  }

  def exercise1 : String = {
    "all the method for Double"
  }
  
  def exercise2 (n: Double) : Double = {
    val v = Math.sqrt(n)
    val v1 = Math.pow(v, 2)
    n-v1
  }
  
  def exercise3 : String = {
    "val"
  }
  
  def exercise4 : String = {
    "crazy" * 3
  }
  
  def exercise5 : String = {
    "invoking 10 max 2 from Math.max gives " + (10 max 2) 
  }
  
  def exercise6 : BigInt = {
    BigInt(2).pow(1024)
  }
  def exercise7 : BigInt = {
    probablePrime(100, new Random(2))
  }
  def exercise8 : String = {
    BigInt(Random.nextInt).toString(36)
  }
  def exercise9 (v : String) : String = {
    v.head.toString + v.last.toString
  }
  def exercise10 (v : String) : String = {
    v.take(3) + v.drop(3) + v.takeRight(3) + v.dropRight(3)
  }
  
}
