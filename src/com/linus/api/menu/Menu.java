package com.linus.api.menu;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})
public class Menu {
  private Long id;
  private String item;//ex) "1-회원가입"
  private String category; //user, board

  @Builder(builderMethodName = "builder")
  public Menu(Long id, String item, String category) {
    this.item = item;
    this.category = category;
  }
}
//insert into menus(item, category) values("1-회원가입","users");