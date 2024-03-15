package com.linus.api.Article;

import lombok.Builder;
import lombok.ToString;

@ToString

public class Article {
  private Long id;
  private String title;
  private String content;
  private String writer;
  private String registerDate;

  @Builder(builderMethodName = "builder")
  public Article(Long id, String title, String content, String  writer, String registerDate){
    this.id = id;
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.registerDate = registerDate;
  }
}
