package Post;

import java.sql.*;

public class PostRepository {
  private static PostRepository instance;

  static {
    try {
      instance = new PostRepository();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  PostRepository postRepository;
  private Connection connection;

  private PostRepository() throws SQLException {
    this.postRepository = PostRepository.getInstance();
    this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linusdb", "linus", "password");
  }
  public static PostRepository getInstance(){return instance;}

  public void findAllPost() throws SQLException {
    String sql = "select * from posts";

    PreparedStatement pstmt = connection.prepareStatement(sql);
    ResultSet resultSet = pstmt.executeQuery();
    if(resultSet.next()){
      do{
        System.out.printf("ID : %d\t Title : %s\t Content : %s\t Writer : %s\n",
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getString("writer"));
      }
      while (resultSet.next());
    }
  }
}
