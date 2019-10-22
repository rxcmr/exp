package expr;

import org.jetbrains.annotations.Contract;

interface Lock {
   void acquire() throws InterruptedException;
   void release();
}

class Semaphore implements Lock {
   private final int msg;
   private int ctr;

   @Contract(pure = true)
   Semaphore(int msg) {
      this.msg = msg;
      this.ctr = msg;
   }

   public int getMsgAmount() {
      return msg;
   }

   public int getAvailableMsg() {
      return ctr;
   }

   @Override
   public synchronized void acquire() throws InterruptedException {
      while (ctr == 0) {
         wait();
      }
      ctr -= 1;
   }

   @Override
   public synchronized void release() {
      if (ctr < msg) {
         ctr += 1;
         notify();
      }
   }
}

public class EX13 {

}