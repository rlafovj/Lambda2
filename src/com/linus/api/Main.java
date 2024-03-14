package com.linus.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.linus.api.enums.*;

public class Main {
  public static void main(String[] args) throws IOException, SQLException {
    Scanner sc = new Scanner(System.in);
    String stringFlag = NavigatorOfFunction.select(sc);
    while(!stringFlag.equals("x"));
//    NavigatorOfConsumer.select(sc);
//    boolean booleanFlag = NavigatorOfPredicate.select(sc);
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


