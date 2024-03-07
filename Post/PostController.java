package Post;

import java.sql.SQLException;

public class PostController {
  PostService postService;

  public void findAllPost() throws SQLException {
    this.postService = PostServiceImpl.getInstance();
    postService.findAllPost();
  }
}
