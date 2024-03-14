package com.linus.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;

public class NavigatorOfConsumer {
//  Exit("x", i -> "s"),
//  User("u", i -> "s"),
//  Board("b", i -> "s"),
//  Account("a", i -> "s"),
//  Crawler("c", i -> "s"),
//  Post("p", i -> "s")
  ;

  private final String code;
  private final Consumer<?> selectMenu;

  public NavigatorOfConsumer(String code, Consumer<?> selectMenu) {
    this.code = code;
    this.selectMenu = selectMenu;
  }

  public static String select(Scanner sc) {
    System.out.println("=== x-Exit " +
            "u-User " +
            "b-Board " +
            "a-Account " +
            "c-Crawler " +
            "p-Post" +
            "===");
    String str = sc.next();
    return null;
  }
}
