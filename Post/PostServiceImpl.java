package Post;

import java.sql.SQLException;

public class PostServiceImpl implements PostService{
  private PostRepository postRepository;
  private static PostServiceImpl instance = new PostServiceImpl();
  private PostServiceImpl(){
    postRepository = PostRepository.getInstance();
  }
  public static PostServiceImpl getInstance(){return instance;}

  @Override
  public void findAllPost() throws SQLException {
    postRepository.findAllPost();
  }
}
