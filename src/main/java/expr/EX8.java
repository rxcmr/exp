package expr;

import org.jetbrains.annotations.Contract;

interface Function { double evaluate(double x); }
interface Integral { double integrate(double lowerBounds, double upperBounds); }

class _EX8_Return_Limits {
   private double c;
   @Contract(pure = true)
   _EX8_Return_Limits(double c) { this.c = c; }
   Function f_of_x;
   Integral integral = (var a, var b) -> f_of_x.evaluate(c) * b - f_of_x.evaluate(c) * a;
}

public class EX8 {
   public static void main(String[] args) {
      var returnLimits = new _EX8_Return_Limits(10);
      returnLimits.f_of_x = (var x) -> 2 * x;
      var rlm_result = returnLimits.integral.integrate(0, 5);
      System.out.println("Return limits result: " + rlm_result);
   }
}