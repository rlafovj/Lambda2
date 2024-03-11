package com.linus.api;

import com.linus.api.Post.PostView;
import com.linus.api.account.AccountView;
//import com.linus.api.auth.AuthView;
import com.linus.api.board.BoardView;
import com.linus.api.crawler.CrawlerView;
import com.linus.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException, SQLException {
    Scanner sc = new Scanner(System.in);

    while (true){
      System.out.println("=== x-Exit " +
              "u-User " +
              "b-Board " +
              "a-Account " +
              "c-Crawler " +
              "p-Post" +
              "===");
      switch (sc.next()){
        case "x":  return;
        case "u": UserView.main(sc);break;
        case "b": BoardView.main(); break;
        case "a": AccountView.main(sc); break;
        case "c": CrawlerView.main(sc); break;
        case "p": PostView.main(sc); break;
      }
    }
  }
}


