package expr;

class EX2 extends Exception {
   EX2() {}
   EX2(String message) {
      super(message);
   }
   EX2(Throwable cause) {
      super(cause);
   }
   EX2(String message, Throwable cause) {
      super(message, cause);
   }
   EX2(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
   }
}
