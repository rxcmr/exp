package expr;

import org.jetbrains.annotations.Contract;

import java.nio.ByteBuffer;
import java.util.Base64;

public class EX14 {
   static class Base16 {
      String convert(int x) {
         return Integer.toHexString(x);
      }
   }

   static class Base8 {
      String convert(int x) {
         return Integer.toOctalString(x);
      }
   }

   static class Base2 {
      String convert(int x) {
         return Integer.toBinaryString(x);
      }
   }

   public static void main(String[] args) {
      Base16 base16 = new Base16();
      Base8 base8 = new Base8();
      Base2 base2 = new Base2();
      System.out.println(base16.convert(100));
      System.out.println(base8.convert(100));
      System.out.println(base2.convert(100));
   }
}
