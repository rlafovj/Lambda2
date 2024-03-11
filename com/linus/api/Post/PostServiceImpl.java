package com.linus.api.Post;

import com.linus.api.common.AbstractService;
import com.linus.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PostServiceImpl extends AbstractService implements PostService{
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

  @Override
  public Messenger save(Object o) {
    return null;
  }

  @Override
  public List<?> findAll() throws SQLException {
    return postRepository.findAll();
  }

  @Override
  public Optional<?> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public String count() {
    return null;
  }

  @Override
  public Optional<?> getOne(String id) {
    return Optional.empty();
  }

  @Override
  public String delete(Object o) {
    return null;
  }

  @Override
  public Boolean existsById(Long id) {
    return null;
  }
}
