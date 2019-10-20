package expr;

interface Function { double evaluate(double x); }

interface Integral { double integrate(double lowerBounds, double upperBounds); }

class _EX8_Midpoint_Rule {
   Function f_of_x; // the function f(x)
   Integral integral = (a, b) -> (b - a) * f_of_x.evaluate((a + b) / 2);
}

class _EX8_Trapezoidal_Rule {
   Function f_of_x; // the function f(x)
   Integral integral = (a, b) -> (b - a) * ((f_of_x.evaluate(a) + f_of_x.evaluate(b)) / 2);
}

public class EX8 {
   public static void main(String[] args) {
      _EX8_Midpoint_Rule midpointRule = new _EX8_Midpoint_Rule();
      midpointRule.f_of_x = x -> 2 * x; // evaluate the function f(x) = 2x
      midpointRule.f_of_x.evaluate(9); // f(9) = 2 * 9, f(9) = 81
      double mpr_result = midpointRule.integral.integrate(0, 9); // Integral[0, 9] 2x dx
      System.out.println("Midpoint rule result: " + mpr_result);

      _EX8_Trapezoidal_Rule trapezoidalRule = new _EX8_Trapezoidal_Rule();
      trapezoidalRule.f_of_x = x -> 2 * x; // evaluate the function f(x) = 2x
      trapezoidalRule.f_of_x.evaluate(9); // f(9) = 2 * 9, f(9) = 81
      double tzr_result = trapezoidalRule.integral.integrate(0, 9); // Integral[0, 9] 2x dx
      System.out.println("Trapezoidal rule result: " + tzr_result);
   }
}


