package com.linus.api.menu;
import com.linus.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
  Messenger makeMenuTable();

  Messenger removeTable();

  List<?> getMenusByCategory(String category);

  Messenger returnMessenger() throws SQLException;

  List<?> returnAllMenus() throws SQLException;

  Menu returnOneMenu() throws SQLException;
}
