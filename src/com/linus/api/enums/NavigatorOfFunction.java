package com.linus.api.enums;

import com.linus.api.Post.PostView;
import com.linus.api.account.AccountView;
import com.linus.api.board.BoardView;
import com.linus.api.crawler.CrawlerView;
import com.linus.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;

public enum NavigatorOfFunction {
  Exit("Exit", i -> "x"),
  User("User", i -> {
    try {
      UserView.main(i);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return "";
  }),
  Board("Board", i -> {BoardView.main();
  return "";}),
  Account("Account", i -> {AccountView.main(i);
  return "";}),
  Crawler("Crawler", i -> {
    try {
      CrawlerView.main(i);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return "";
  }),
  Post("Post", i -> {
    try {
      PostView.main(i);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return "";
  })
  ;
  private final String code;
  private final Function<Scanner, String> selectMenu;

  NavigatorOfFunction(String code, Function<Scanner, String> selectMenu) {
    this.code = code;
    this.selectMenu = selectMenu;
  }

  public static String select(Scanner sc){
    System.out.println("=== x-Exit " +
            "u-User " +
            "b-Board " +
            "a-Account " +
            "c-Crawler " +
            "p-Post" +
            "===");
    String str = sc.next();
    return str;
  }
}
