package com.linus.api.menu;

import com.linus.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
  MenuService menuService;
  private static MenuController instance = new MenuController();
  private MenuController (){
    this.menuService = MenuServiceImpl.getInstance();
  }
  public static MenuController getInstance(){return instance;}

  public Messenger makeMenuTable(){
    return menuService.makeMenuTable();
  }
  public Messenger removeMenuTable(){
    return menuService.removeTable();
  }

  public List<?> getMenusByCategory(String category){
    return menuService.getMenusByCategory(category);
  }

  public Messenger returnMessenger() throws SQLException {
    return menuService.returnMessenger();
  }

  public List<?> returnAllMenus() throws SQLException {
    return menuService.returnAllMenus();
  }

  public Menu returnOneMenu() throws SQLException {
    return menuService.returnOneMenu();
  }
}
