package expr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX10 {
   private ExecutorService service;

   private void setService(ExecutorService service) {
      this.service = service;
   }

   private ExecutorService getService() {
      return service;
   }

   public static void main(String[] args) {
      var ex10 = new EX10();
      ex10.setService(Executors.newCachedThreadPool());
      for (int i = 0; i < 30; i++) {
         ex10.getService().execute(() -> System.out.println("Task executed!"));
      }
      ex10.getService().shutdown();
   }
}
