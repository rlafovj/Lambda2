package com.linus.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.linus.api.enums.*;
import com.linus.api.menu.Menu;
import com.linus.api.menu.MenuController;
import lombok.ToString;

public class Main {
  private static final Scanner sc = new Scanner(System.in);
  public static void main(String[] args) throws IOException, SQLException {
    //MenuController.getInstance().makeMenuTable();

//    Messenger msg = MenuController.getInstance().returnMessenger();
//    Menu oneMenu = MenuController.getInstance().returnOneMenu();
//    List<?> allMenu = MenuController.getInstance().returnAllMenus();

//    while(true) {
//      String stringFlag = NavigatorOfFunction.select(sc);
//      if(stringFlag.equals("x")){
//        break;
//      }
//    }
//    NavigatorOfConsumer.select(sc);
    //boolean booleanFlag =
    while (NavigatorOfPredicate.select(sc));
//    while (booleanFlag);
//    NavigatorOfSupplier.select(sc);

//    while (true) {
//      System.out.println("=== x-Exit " +
//              "u-User " +
//              "b-Board " +
//              "a-Account " +
//              "c-Crawler " +
//              "p-Post" +
//              "===");
//      Navigator np = Navigator.getNavigator(sc.next());
//      if (np != null) {
//        np.execute(sc);
//        if (np == Navigator.EXIT) {
//          break;}
//        } else System.out.println("ERROR");
//      }
    }
  }


