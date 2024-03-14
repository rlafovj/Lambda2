package com.linus.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public enum NavigatorOfPredicate {
  Exit("x", i -> false),
  User("u", i -> true),
  Board("b", i -> true),
  Account("a", i -> true),
  Crawler("c", i -> true),
  Post("p", i -> true)
  ;
  private final String code;
  private final Predicate<Scanner> selectMenu;

  NavigatorOfPredicate(String code, Predicate<Scanner> selectMenu) {
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
