package expr;

import static java.lang.Math.PI;

class CartesianToPolar {
   private double r, thetaInRadians, thetaInDegrees;

   CartesianToPolar(double x, double y) {
      r = Math.hypot(x, y); // Pythagorean Theorem
      thetaInRadians = Math.atan2(y, x); // arctangent2
      thetaInDegrees = (x >= 0 ? x : (2 * PI + x)) * 180 / PI;
   }

   double calculateHypot() { return r; }
   double calculateAngleInRadians() { return thetaInRadians; }
   double calculateAngleInDegrees() { return Math.round(thetaInDegrees); }
}

class PolarToCartesian {
   private double x, y;
   PolarToCartesian(double r, double theta) {
      x = r * Math.cos(theta);
      y = r * Math.sin(theta);
   }

   double calculateAbscissa() { return x; }
   double calculateOrdinate() { return y; }
}

public class EX9 {
   public static void main(String[] args) {
      CartesianToPolar cartesianToPolar = new CartesianToPolar(3, 5);
      System.out.printf("r = %s, θ = %s or %s°%n",
         cartesianToPolar.calculateHypot(), cartesianToPolar.calculateAngleInRadians(), cartesianToPolar.calculateAngleInDegrees());
      PolarToCartesian polarToCartesian = new PolarToCartesian(5.830951894845301, 1.0303768265243125);
      System.out.printf("x = %s, y = %s%n", polarToCartesian.calculateAbscissa(), polarToCartesian.calculateOrdinate());
   }
}
