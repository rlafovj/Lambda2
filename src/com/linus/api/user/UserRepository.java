package com.linus.api.user;

import com.linus.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
  private static UserRepository instance;
  private PreparedStatement pstmt;
  private ResultSet resultSet;

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
    pstmt = null;
    resultSet = null;
  }
  public static UserRepository getInstance(){return instance;}
  public String test(){
    return "UserRepository 연결";
  }
  public List<?> findUsers() throws SQLException {
    String sql = "select * from users";

    PreparedStatement pstmt = connection.prepareStatement(sql);
    ResultSet resultSet = pstmt.executeQuery();
    List<User> ls = new ArrayList<>();
    if(resultSet.next()){
      do{
        ls.add(User.builder()
                        .id( resultSet.getLong("id"))
                        .username(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .name(resultSet.getString("name"))
                        .phoneNumber(resultSet.getString("phone"))
                        .job(resultSet.getString("job"))
                .build());
      }
      while (resultSet.next());
    }else System.out.println("데이터가 없습니다.");

//    resultSet.next();
//    String name = resultSet.getString("writer");
//    System.out.println(name);

    return ls;
  }

  public Messenger touchTable() throws SQLException {
    String sql =  "CREATE TABLE IF NOT EXISTS members (\n" +
            "                       id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "                       member_name VARCHAR(20) NOT NULL,\n" +
            "                       password VARCHAR(20) NOT NULL,\n" +
            "                       name VARCHAR(20),\n" +
            "                       phone_number VARCHAR(20),\n" +
            "                       job VARCHAR(20),\n" +
            "                       height VARCHAR(20),\n" +
            "                       weight VARCHAR(20)\n)";
    PreparedStatement pstmt = connection.prepareStatement(sql);
    System.out.println("ex : "+pstmt.executeUpdate());

    pstmt.close();
    connection.close();

    return (this.pstmt.executeUpdate() == 0) ? Messenger.SUCCESS:Messenger.FAIL;
  }
  public void removeTable() {
  }
}
