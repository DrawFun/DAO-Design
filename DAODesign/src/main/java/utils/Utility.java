package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

/**
 * Created by Dzf on 2017/7/27.
 */
public class Utility {
  private static final ObjectMapper mapper = new ObjectMapper();

  private static String getSpecificField(String fieldName) {
    String userName = null;
    try {
      InputStream in  = Utility.class.getResourceAsStream("/db.json");
      JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
      userName = jsonNode.get(fieldName).asText();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return userName;
  }

  public static String getDBUrl() {
    return getSpecificField("url");
  }

  public static String getDBUserName() {
    return getSpecificField("user");
  }

  public static String getDBPassword() {
    return getSpecificField("password");
  }
}
