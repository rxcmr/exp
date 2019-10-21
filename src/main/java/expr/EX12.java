package expr;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jetbrains.annotations.Contract;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

class EX12 {
   private String name;
   private int age;
   private HashMap<String, String> credentials;
   private String[] permissions;

   @Contract(pure = true)
   String getName() { return name; }
   @Contract(pure = true)
   int getAge() { return age; }
   @Contract(pure = true)
   HashMap<String, String> getCredentials() { return credentials; }
   @Contract(pure = true)
   String[] getPermissions() { return permissions; }

   void setName(String name) { this.name = name; }
   void setAge(int age) { this.age = age; }
   void setCredentials(HashMap<String, String> credentials) { this.credentials = credentials; }
   void setPermissions(String[] permissions) { this.permissions = permissions; }

   private void parseYAML() {
      ObjectMapper objmap = new ObjectMapper(new YAMLFactory());
      try {
         EX12 ex12 = objmap.readValue(new File("src\\main\\resources\\EX12.yaml"), EX12.class);
         System.out.println(ReflectionToStringBuilder.toString(ex12, ToStringStyle.MULTI_LINE_STYLE));
      } catch (IOException ignored) {}
   }

   public static void main(String[] args) {
      EX12 ex12 = new EX12();
      ex12.parseYAML();
   }
}