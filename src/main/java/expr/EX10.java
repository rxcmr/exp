package expr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface RunningTask {
   void exec(ExecutorService service);
}

public class EX10 {
   RunningTask task = (service) -> {
      service = Executors.newCachedThreadPool();
      service.execute(
         () -> {
            // ... do something inside runnable task
         });
      service.shutdown();
   };
}
