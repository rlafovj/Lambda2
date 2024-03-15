package com.linus.api.Article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
  private ArticleServiceImpl postService;

  public void findAllPost() throws SQLException {
    this.postService = ArticleServiceImpl.getInstance();
    postService.findAllPost();
  }

  public List<?> findAll() throws SQLException {
    return postService.findAll();
  }
}
