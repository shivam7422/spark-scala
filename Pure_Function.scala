package programs
/* Functional programming is a way of writing software applications using only pure functions and immutable values.
A pure function is a function that depends only on its declared inputs and its internal algorithm to produce its output.
 > Output depends only on input
 > No side effects
> It does not read any other values from “the outside world.
> It cannot modify any hidden fields outside of the function scope, other mutable fields in the same class or global variables.
> It cannot depend on any external I/O. It can’t rely on input from files, databases, web services
Same Data type + Same return type.
the world outside of the function’s scope — and it does not modify any values in the outside world.
  > Methods like these in scala.math._ are all pure functions: abs, ceil, max, min
  > Because a Scala String is immutable, every method available to a String is a pure function: charAt, isEmpty, length, substring
  > Many methods that are available on Scala’s collections’ classes fit the definition of a pure function, including the common ones:
drop, filter, map, reduce

Methods on the scala.util.Random class like nextInt,getDayOfWeek, getHour, and getMinute,foreach,readLine are impure functions.

*/

object Pure_Function extends App{

  def test(a:Int)={
    val b:Int = a * a;
    println("Square of the number is " + b);
    println("Number is " + a);
  }
  test(4)
}
