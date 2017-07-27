package dao;

import dto.Student;
import utils.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

/**
 * Created by Dzf on 2017/7/27.
 */
public class NoDAOClass {
  private static Connection getConnection() {
    String driver = "com.mysql.jdbc.Driver";
    Connection connection = null;
    try {
      Class.forName(driver);
      String url = Utility.getDBUrl();
      String userName = Utility.getDBUserName();
      String password = Utility.getDBPassword();
      connection = DriverManager.getConnection(url, userName, password);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return connection;
  }

  private static boolean releaseConnection(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
        return true;
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return false;
  }

  public static int insert(Student student) {
    int result = -1;
    Connection connection = getConnection();
    if (student != null && connection != null) {
      String sql = "INSERT INTO Student (name, sex, age, math, literature) value(?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = null;
      try {
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getSex());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setInt(4, student.getMath());
        preparedStatement.setInt(5, student.getLiterature());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return result;
  }

  public static void main(String[] args) {
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
      insert(new Student(name, sex, age, math, literature));
    }
  }

}
