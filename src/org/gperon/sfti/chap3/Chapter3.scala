/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gperon.sfti.chap3
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Buffer
import scala.collection.mutable.ArrayOps
import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer

object Chapter3 {
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
//    intro
    println("Chapter 3: Working with Arrays")
    val a = exercise1(10)
    println("Exercise 1 array random number from 0 to 10 = " + printArray(a))
    exercise2(a)
    println("Exercise 2 array swap in place = " + printArray(a))
    println("Exercise 3 array swap = " + printArray(exercise3(a)))
    val a1 = myRandomArray(10)
    println("Exercise 4 array all positive then all negative = " + printArray(a1) + " then " + exercise4(a1).mkString(" "))
    val a2 = myRandomArrayDouble(10)
    println("Exercise 5 array average of " + printArray(a2) + " is " + exercise5(a2))
    println("Exercise 6 rever sorted array " + printArray(a) + " is " + exercise6(a))
    println("Exercise 7 distinct array " + printArray(a) + " is " + exercise7(a))
    val a3 = ArrayBuffer(6, 6, -2, 9, 7, -9, 0, -1, 8, -5)
    
    print("Exercise 8 remove negative but the first " + a3.mkString(" ") + " is ")
    exercise8(a3)
    println(a3.mkString(" "))
    println("Exercise 9 " + exercise9.mkString(" "))
    println("Exercise 10 " + exercise10.mkString(" "))
    
  }
  
  def intro {
    val nums = new Array[Int](10)
    val a = new Array[String](10)

  }

  def exercise1 (n : Int) : Array[Int] = {
    val a = new Array[Int](n)
    
    for(i <- 0 until n) 
      a(i) = Random.nextInt(n)
    a
  }
  def exercise3 (a : Array[Int]) : Array[Int] = {
    val aa = new Array[Int](a.length)
    
    for(i <- 0 until(a.length, 2))  {
      aa(i) = a(i+1)
      aa(i+1) = a(i)
    }
    aa
  }
  
  def exercise2 (a : Array[Int]) = {
    for(i <- 0 until(a.length, 2))  {
      val ai = a(i)
      val aii = a(i+1)
      a(i) = aii
      a(i+1) = ai
    }
  }
  
  def exercise4 (a : Array[Int]) : ArrayBuffer[Int] = {
    val aaPlus = new ArrayBuffer[Int]
    val aaMinus = new ArrayBuffer[Int]
    for(i <- 0 until a.length)  {
      if (a(i)>0) {
        aaPlus.append(a(i))
      } else {
        aaMinus.append(a(i))
      }
    }
    aaPlus.appendAll(aaMinus)
    aaPlus
  }
  
  def exercise5 (a : Array[Double]) : Double = {
    a.sum/a.length
  }
  
  def array2buffer(a : Array[Int]) : ArrayBuffer[Int] = {
    val aa = new ArrayBuffer[Int](a.length)
    for(elem<-a)
      aa.append(elem)
    aa
  }
  
  def exercise6 (a : Array[Int]) : ArrayBuffer[Int] = {
    exercise6(array2buffer(a))
  }
  
  def exercise6 (a : ArrayBuffer[Int]) : ArrayBuffer[Int] = {
    a.sorted.reverse
  }
  
  def exercise7 (a : Array[Int]) : ArrayBuffer[Int] = {
    exercise7(array2buffer(a))
  }
  
  def exercise7 (a : ArrayBuffer[Int]) : ArrayBuffer[Int] = {
    a.distinct
  }
  
  def printArray (a : Array[_]) : String = {
    var s = "["
    for (elem <- a) 
      s += elem + " "
    s + "]"
  }
  
  def myRandomArray(n : Int) : Array[Int] = {
    val a = new Array[Int](n)
    
    for(i <- 0 until n) 
      if (Random.nextBoolean) {
        a(i) = Random.nextInt(n)
      } else {
        a(i) = -Random.nextInt(n)
      }
    a
  }
  def myRandomArrayDouble(n : Int) : Array[Double] = {
    val a = new Array[Double](n)
    
    for(i <- 0 until n) 
      if (Random.nextBoolean) {
        a(i) = Random.nextDouble()*Random.nextInt(n)
      } else {
        a(i) = -Random.nextDouble()*Random.nextInt(n)
      }
    a
  }
  
  def trasf1(a : ArrayBuffer[Int]) = {
    var first = true
    var n = a.length
    var i = 0
    while (i<n) {
      if (a(i) >=0) i +=1
      else {
        if (first) { first = false; i +=1}
        else {a.remove(i); n-=1}
      }
    }
  }
  def trasf2(a : ArrayBuffer[Int]) = {
    var first = true
    val indexes = for (i<-0 until a.length if first || a(i)>=0) yield {
      if (a(i) <0) first = false; i
    }
    for (j <- 0 until indexes.length) a(j) = a(indexes(j))
    a.trimEnd(a.length-indexes.length)
  }
  
  def exercise8(a : ArrayBuffer[Int]) = {
    var indexes = for (i<-0 until a.length if a(i)<0) yield i
    indexes = indexes.reverse
    indexes = indexes.dropRight(1)
    for (j <- 0 until indexes.length) a.remove(indexes(j))
  }
  def exercise9(): ArrayBuffer[String] = {
    val a = ArrayBuffer[String]()
    a.appendAll(java.util.TimeZone.getAvailableIDs)
    val aa = a.filter(_.startsWith("America/")).map(_.substring(8))
//    val aa = for (elem <- a if elem.startsWith("America/")) yield elem.substring(8)
    aa.sorted
  }
  
  def exercise10(): Buffer[String] = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  }
}
