package com.linus.api.user;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class User {
  private Long id;
  private String username;
  private String password;
  private String name;
  private String ssn;
  private String phoneNumber;
  private String addressID;
  private String job;
  private double height;
  private double weight;

  @Builder(builderMethodName = "builder")
  public User(Long id, String username, String password,
              String name, String ssn, String phoneNumber,
              String address, String job,
              double height, double weight) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.ssn = ssn;
    this.phoneNumber = phoneNumber;

    this.job = job;
    this.height = height;
    this.weight = weight;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}