package com.linus.api.enums;

import com.linus.api.user.UserView;

import java.util.Scanner;
import java.util.function.Supplier;

public enum NavigatorOfSupplier {
//  Exit("x", i -> "s"),
//  User("u", i -> "s"),
//  Board("b", i -> "s"),
//  Account("a", i -> "s"),
//  Crawler("c", i -> "s"),
//  Post("p", i -> "s")
  ;

  private final String code;
  private final Supplier<?> selectMenu;

  NavigatorOfSupplier(String code, Supplier<Scanner> selectMenu) {
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
