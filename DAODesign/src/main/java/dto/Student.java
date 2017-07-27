package dto;

/**
 * Created by Dzf on 2017/7/27.
 */
public class Student {
  private int id;
  private String name;
  private String sex;
  private int age;
  private int math;
  private int literature;

  public Student(String name, String sex, int age, int math, int literature) {
    this.id = -1;
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.math = math;
    this.literature = literature;
  }

  public Student(int id, String name, String sex, int age, int math, int literature) {
    this(name, sex, age, math, literature);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getLiterature() {
    return literature;
  }

  public void setLiterature(int literature) {
    this.literature = literature;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", age=" + age +
            ", math=" + math +
            ", literature=" + literature +
            '}';
  }
}
