package exercise2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FractionTest {

 @Test
 fun consBasic1() {
  val a = Fraction(1,2)
  assert(a.toString() == "1/2")
 }

 @Test
 fun consBasic2() {
  val a = Fraction(6,12)
  assert(a.toString() == "1/2")
 }

 @Test
 fun consNeg() {
  val a = Fraction(1,2, -1)
  assert(a.toString() == "-1/2")
 }

 @Test
 fun consReduce() {
  val a = Fraction(4,20)
  assert(a.toString() == "1/5")
 }

 @Test
 fun consReduceNeg() {
  val a = Fraction(4,20, -1)
  assert(a.toString() == "-1/5")
 }

 @Test
 fun compareToEq() {
  assert(Fraction(1,2).compareTo(Fraction(2,4)) == 0)
 }

 @Test
 fun compareToGt() {
  assert(Fraction(1,2).compareTo(Fraction(2,5)) == 1)
 }

 @Test
 fun compareToLt() {
  assert(Fraction(1,3).compareTo(Fraction(2,5)) == -1)
 }

 @Test
 fun negate1() {
  assert(Fraction(1,2).negate().toString() == "-1/2")
 }

 @Test
 fun negate2() {
  assert(Fraction(1,2, -1).negate().toString() == "1/2")
 }

 @Test
 fun add() {
  assertEquals(Fraction(13, 12), Fraction(11, 12).add(Fraction(1, 6)))
 }

 @Test
 fun plus() {
  assertEquals(Fraction(1, 1), Fraction(2, 3) + Fraction(1, 3))
 }

 @Test
 fun subtr() {
  assertEquals(Fraction(2, 3), Fraction(5, 6).subtract(Fraction(1, 6)))
 }

 @Test
 fun minus() {
  assertEquals(Fraction(1, 2), Fraction(3, 4) - Fraction(1, 4))
 }

 @Test
 fun mult() {
  assertEquals(Fraction(1, 2), Fraction(2, 3).multiply(Fraction(3, 4)))
 }

 @Test
 fun div() {
  assertEquals(Fraction(9, 8), Fraction(3, 4).divide(Fraction(2, 3)))
 }
}