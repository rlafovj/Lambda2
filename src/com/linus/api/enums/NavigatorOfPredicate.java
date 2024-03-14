package com.linus.api.enums;

import com.linus.api.user.UserView;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigatorOfPredicate {
  Exit("x", i -> false),
  User("u", i -> {
    try {
      UserView.main(i);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return true;}),
  Board("b", i -> true),
  Account("a", i -> true),
  Crawler("c", i -> true),
  Post("p", i -> true),
  ;
  private final String code;
  private final Predicate<Scanner> selectMenu;

  NavigatorOfPredicate(String code, Predicate<Scanner> selectMenu) {
    this.code = code;
    this.selectMenu = selectMenu;
  }

  public static boolean select(Scanner sc) {
    System.out.println("=== x-Exit " +
            "u-User " +
            "b-Board " +
            "a-Account " +
            "c-Crawler " +
            "p-Post" +
            "===");
    String str = sc.next();
    return Stream.of(values())
            .filter(i -> i.code.equals(str))
            .findFirst().orElse(Exit)
            .selectMenu.test(sc);

  }
}
