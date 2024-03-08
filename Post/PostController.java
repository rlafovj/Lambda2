package Post;

import java.sql.SQLException;
import java.util.List;

public class PostController {
  private PostServiceImpl postService;

  public void findAllPost() throws SQLException {
    this.postService = PostServiceImpl.getInstance();
    postService.findAllPost();
  }

  public List<?> findAll() throws SQLException {
    return postService.findAll();
  }
}
