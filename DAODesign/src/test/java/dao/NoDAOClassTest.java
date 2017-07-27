package dao;

import dto.Student;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Dzf on 2017/7/27.
 */
public class NoDAOClassTest {

  @Test
  public void insertTest() {
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      int nameLength = random.nextInt(10) + 1;
      char[] nameChars = new char[nameLength];
      for (int j = 0; j < nameChars.length; j++) {
        nameChars[j] = (char)('A' + random.nextInt(26));
      }
      String name = String.valueOf(nameChars);
      String sex = random.nextBoolean() ? "male" : "female";
      int age = random.nextInt(20) + 10;
      int math = random.nextInt(100);
      int literature = random.nextInt(100);
      NoDAOClass.insert(new Student(name, sex, age, math, literature));
    }
  }
}
