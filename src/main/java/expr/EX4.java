package expr;

import java.io.*;
import java.util.HashMap;

class EX4 {
   private final String path = "src\\main\\resources\\EX4.csv";
   private String username, password;
   boolean isPasswordCorrect;
   private HashMap<String, String> hashMap = new HashMap<>();

   EX4(String username, String password) {
      this.username = username;
      this.password = password;
   }

   void parseCSV() {
      // replace the path to your liking
      String field, delimiter = ",";
      try (BufferedReader rdr = new BufferedReader(new FileReader(path))) {
         // we ignore the first line
         rdr.readLine();
         while ((field = rdr.readLine()) != null) {
            String[] data = field.split(delimiter);
            data[0] = data[0].replace("\"", "");
            data[1] = data[1].replace("\"", "");
            hashMap.put(data[0], data[1]);
         }
      } catch (IOException e) {
         System.err.println("CSV file not found.");
         System.out.println("Creating CSV file...");
         try { createCSV(); }
         catch (IOException ex) {
            System.err.println("Unable to create CSV file.");
         }
      } finally { passwordCheck(); }
   }
   
   private void passwordCheck() {
      if (hashMap.get(username) == null) {
         isPasswordCorrect = false;
         System.err.println("Parsing failed.");
      } else isPasswordCorrect = hashMap.get(username).equals(password);
   }

   private void createCSV() throws IOException {
      File file = new File(path);
      BufferedWriter wtr = new BufferedWriter(new FileWriter(file));
      if (file.exists()) {
         System.err.println("File exists.");
         System.err.println("Overwriting contents...");
         wtr.write("\"Username\",\"Password\"");
         // replace these as you please
         wtr.write("\n\"Alan\",\"IaMaLaN1234\"");
         wtr.write("\n\"Bert\",\"MyPassWorD1$s3cUr3\"");
         wtr.write("\n\"Gilbert\",\"1234567890\"");
         wtr.close();
      } else if (file.createNewFile()) {
         wtr.write("\"Username\",\"Password\"");
         // replace these as you please
         wtr.write("\n\"Alan\",\"IaMaLaN1234\"");
         wtr.write("\n\"Bert\",\"MyPassWorD1$s3cUr3\"");
         wtr.write("\n\"Gilbert\",\"1234567890\"");
         wtr.close();
      }
   }
}
