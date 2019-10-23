package expr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.String.format;
import static java.lang.System.err;
import static java.lang.System.out;

public class EX11 {
   private double a, b, c;
   private int gcf = 1;

   private void init() {
      boolean wasNotSuccessful;
      do {
         try (BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in))) {
            out.println("Quadratic equation must be in standard form of ax\u00b2 + bx + c.");
            out.print("Value of a: ");
            a = parseDouble(rdr.readLine());
            out.print("Value of b: ");
            b = parseDouble(rdr.readLine());
            out.print("Value of c: ");
            c = parseDouble(rdr.readLine());
            wasNotSuccessful = false;
         } catch (Exception e) {
            err.println("Invalid input.");
            wasNotSuccessful = true;
         }
         if (!wasNotSuccessful) {
            solve();
         }
      } while (wasNotSuccessful);
   }

   private void simplify() {
      double discriminant = pow(b, 2) - (4 * a * c);
      for (int i = 1; i <= b && i <= -discriminant && i <= (-2 * a); i++) {
         if (b % i == 0 && -discriminant % i == 0 && (-2 * a) % i == 0) {
            gcf = i;
         } else if (-b % i == 0 && discriminant % i == 0 && (2 * a) % i == 0) {
            gcf = i;
         }
      }
   }

   private void solve() {
      double discriminant = pow(b, 2) - (4 * a * c);
      if (a == 0) {
         err.println("\na is equal to 0.");
         throw new ArithmeticException("a cannot be 0 in a quadratic equation.");
      }
      else {
         if (discriminant > 0) {
            double
               x_1 = (-b + sqrt(discriminant)) / (2 * a),
               x_2 = (-b - sqrt(discriminant)) / (2 * a);
            out.printf("\nx\u2081 = %s, x\u2082 = %s%n", x_1, x_2);
            out.printf("Alternative result: \nx\u2081 = %s + \u221a%s / %s, x\u2082 = %s - \u221a%s / %s", -b, discriminant, a, -b, discriminant, a);
         } else if (discriminant == 0) {
            double x = -b / (2 * a);
            out.printf("\nx = %s", x);
         } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = sqrt(-discriminant) / (2 * a);
            simplify();
            double[]
               p = new double[] { realPart, imaginaryPart },
               f = new double[] { b / gcf,  -discriminant / gcf, (-2 * a) / gcf};
            out.println("\nNo real solutions or roots:");
            final String
               result = format("x\u2081 = %s + i%s, x\u2082 = %s - i%s", p[0], p[1], p[0], p[1]).replaceAll("(- -)", "+ "),
               alternativeResult = format("x\u2081 = %s + i\u221a%s / %s, x\u2082 = %s - i\u221a%s / %s", f[0], f[1], f[2], f[0], f[1], f[2]);
            out.println(result + "\nAlternative result:\n" + alternativeResult);
         }
      }
   }

   public static void main(String[] args) {
      EX11 ex11 = new EX11();
      ex11.init();
   }
}
