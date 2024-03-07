import Post.PostView;
import account.AccountView;
//import auth.AuthView;
import board.BoardView;
import crawler.CrawlerView;
import user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException, SQLException {
    Scanner sc = new Scanner(System.in);

    while (true){
      System.out.println("=== 0-Exit " +
              "1-User " +
              "2-Board " +
              "3-Account " +
              "4-Crawler " +
              "5-Post" +
              "===");
      switch (sc.next()){
        case "0":  return;
        case "1": UserView.main(sc);break;
        case "2": BoardView.main(); break;
        case "3": AccountView.main(sc); break;
        case "4": CrawlerView.main(sc); break;
        case "5": PostView.main(sc); break;
      }
    }
  }
}


