package user;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
  private static UserRepository instance;

  static {
    try {
      instance = new UserRepository();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private Connection connection;

  private UserRepository() throws SQLException {
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linusdb", "linus", "password");
  }
  public static UserRepository getInstance(){return instance;}
  public String test(){
    return "UserRepository 연결";
  }
  public List<?> findUsers() throws SQLException {
    String sql = "select * from board";

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

//    resultSet.next();
//    String name = resultSet.getString("writer");
//    System.out.println(name);


    resultSet.close();
    pstmt.close();
    connection.close();

    return null;
  }

  public List<?> touchTable() {
    return null;
  }

  public void removeTable() {
  }
}
