package com.linus.api.enums;

import com.linus.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
  Exit("x", i -> {
    System.out.println("초기화면으로 돌아가기");
    return false;
  }),
  Join("1", i -> {UserController.getInstance().save(i);
  return true;}),
  Login("2", i -> {UserController.getInstance().login(i);
  return true;}),
  FindID("3", i -> {
    System.out.println((UserController.getInstance().getOne(i)));
  return true;}),
  PasswordChange("4", i -> {UserController.getInstance().updatePassword(i);
  return true;}),
  Withdrawal("5", i -> {UserController.getInstance().delete(i);
  return true;}),
  MemberList("ls", i -> {
    try {
      UserController.getInstance().findUsers();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return true;}),
  FindName("7", i -> {UserController.getInstance().findUsersByName(i);
  return true;}),
  FindJob("8", i -> {UserController.getInstance().findUsersByJob(i);
  return true;}),
  CountUser("9", i -> {UserController.getInstance().count();
  return true;}),
  CreateTable("touch", i -> {
    try {
      UserController.getInstance().touchTable();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return true;
  }),
//  RemoveTable("rm", i -> UserController.getInstance().removeTable())
  ;
  private final String code;
  private final Predicate<Scanner> predicate;

  UserController controller;

  UserRouter(String code, Predicate<Scanner> predicate) {
    this.code = code;
    this.predicate = predicate;
    this.controller = UserController.getInstance();
  }

  public static boolean extracted(Scanner sc) {
    System.out.println("[사용자메뉴] 0-종료\n " +
            "1-회원가입\n " +
            "2-로그인\n " +
            "3-ID검색\n " +
            "4-비번변경\n" +
            "5-탈퇴\n " +
            "ls-회원목록\n " +
            "7-이름검색\n" +
            "8-직업검색\n" +
            "9-회원수\n" +
            "touch-테이블 생성\n" +
            "rm-테이블 삭제\n");
    String str = sc.next();
    return Stream.of(values())
            .filter(i -> i.code.equals(str))
            .findFirst().orElseGet(()->Exit)
            .predicate.test(sc)
            ;

  }
}
