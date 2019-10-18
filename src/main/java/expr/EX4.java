package expr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class EX4 {
   private String username, password;
   boolean isPasswordCorrect;
   private HashMap<String, String> hashMap = new HashMap<>();

   EX4(String username, String password) {
      this.username = username;
      this.password = password;
   }

   void parseCSV() {
      // replace the path to your liking
      String path = "src\\main\\resources\\EX4.csv", field, delimiter = ",";
      try (BufferedReader rdr = new BufferedReader(new FileReader(path))) {
         // we ignore the first line
         rdr.readLine();
         while ((field = rdr.readLine()) != null) {
            String[] data = field.split(delimiter);
            hashMap.put(data[0].replace("\"", ""), data[1].replace("\"", ""));
         }
      } catch (IOException e) {
         // TODO: make this create a CSV file with format ["Username","Password"]
         System.out.println("CSV file not found.");
      } finally { passwordCheck(); }
   }
   
   private void passwordCheck() {
      if (hashMap.get(username) == null) {
         isPasswordCorrect = false;
         System.err.println("Parsing failed.");
      } else {
         isPasswordCorrect = hashMap.get(username).equals(password);
      }
   }
}
