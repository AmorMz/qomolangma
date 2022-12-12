package pers.muzi.builder;

public class User {
  private String name;

  private String address;

  private Integer age;

  private User(String name, String address, Integer age) {
    this.name = name;
    this.address = address;
    this.age = age;
  }

  public static UserBuilder build() {
    return new UserBuilder();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "name: " + this.name + ",\n" + "address: " + this.address + ",\n" + "age: " + this.age + "\n";
  }

  static class UserBuilder {
    private String name;

    private String address;

    private Integer age;

    public UserBuilder name(String name) {
      this.name = name;
      return this;
    }

    public UserBuilder address(String address) {
      this.address = address;
      return this;
    }

    public UserBuilder age(Integer age) {
      this.age = age;
      return this;
    }

    public User builder() {
      return new User(this.name, this.address, this.age);
    }
  }
}
