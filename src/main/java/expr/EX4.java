package expr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class EX4 {
   public static void main(String[] args) {
      // replace the path to your liking
      String path = "src\\main\\resources\\EX4.csv", field, delimiter = ",";
      HashMap<String, String> hashMap = new HashMap<>();
      try (BufferedReader rdr = new BufferedReader(new FileReader(path))) {
         while ((field = rdr.readLine()) != null) {
            String[] data = field.split(delimiter);
            hashMap.put(data[0].replace("\"", ""), data[1].replace("\"", ""));
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         // replace these too
         System.out.println(hashMap.get("Username"));
         System.out.println(hashMap.get("Alan"));
         System.out.println(hashMap.get("Bert"));
         System.out.println(hashMap);
      }
   }
}