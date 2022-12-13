package pers.muzi.pattern.builder;

public class Main {
  public static void main(String[] args) {
    User user = User.build()
        .name("amormz")
        .address("wuhan")
        .age(22).builder();
    System.out.println(user);
  }
}
