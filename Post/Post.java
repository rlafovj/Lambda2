package Post;

import lombok.Builder;

public class Post {
  private Long id;
  private String title;
  private String content;
  private String writer;

  @Builder(builderMethodName = "builder")
  public Post(String title, String content, String  writer){
    this.title = title;
    this.content = content;
    this.writer = writer;
  }
}
