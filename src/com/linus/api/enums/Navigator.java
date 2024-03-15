package com.linus.api.enums;

import com.linus.api.Article.ArticleView;
import com.linus.api.account.AccountView;
import com.linus.api.board.BoardView;
import com.linus.api.crawler.CrawlerView;
import com.linus.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public enum Navigator {
  EXIT("x", sc -> System.out.println("종료") ),
  USER("u", sc -> UserView.main(sc)),
  BOARD("b", sc -> BoardView.main()),
  ACCOUNT("a", sc -> AccountView.main(sc)),
  CRAWLER("c", sc -> CrawlerView.main(sc)),
  ARTICLE("ar", sc -> ArticleView.main(sc))
  ;
  private final String code;
  private final MenuAction selectMenu;

  Navigator(String code, MenuAction selectMenu) {
    this.code = code;
    this.selectMenu = selectMenu;
  }

  public static Navigator getNavigator(String input){
    return Arrays.stream(values())
            .filter(navigator -> navigator.code.equals(input))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 값이 아닙니다."));
  }

  public void execute(Scanner sc) throws SQLException, IOException {
    this.selectMenu.perform(sc);
  }
  interface MenuAction {
    void perform(Scanner sc) throws SQLException, IOException;
  }

}