package com.linus.api.Article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
  public static void main(Scanner scanner) throws SQLException {
    ArticleController pCtrl = new ArticleController();
    while(true) {
      System.out.println("[사용자메뉴] x-종료\n " +
              "1-모든 게시글 확인\n " +
              "2-\n " +
              "3-\n " );
      switch (scanner.next()) {
        case "x":
          System.out.println("종료");
          return;
        case "1":
          System.out.println("1-모든 게시글 확인");
          pCtrl.findAll().forEach(i-> System.out.println(i));
          break;
        case "2":
          System.out.println("2-");
          break;
        case "3":
          System.out.println("3-");
          break;
      }
    }
  }
}
