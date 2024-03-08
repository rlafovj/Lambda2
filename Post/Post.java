package Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString

public class Post {
  private Long id;
  private String title;
  private String content;
  private String writer;
  private String registerDate;

  @Builder(builderMethodName = "builder")
  public Post(Long id, String title, String content, String  writer, String registerDate){
    this.id = id;
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.registerDate = registerDate;
  }
}
