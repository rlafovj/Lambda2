package com.linus.api.account;

import java.util.Scanner;

public class AccountView {
  public static void main(Scanner sc) {
    AccountController accountController = new AccountController();
    while(true){
      System.out.println("[Account] x-Exit mk-Create depo-Deposit " +
              "with-Withdraw bal-Balance rm-Remove ls-a-Account List");
      switch (sc.next()){
        case "x": return;
        case "mk":
          System.out.println("Create Account");
          System.out.println(accountController.createAccount(sc));
          break;
        case "depo":
          System.out.println("Deposit");
          System.out.println(accountController.deposit(sc));
          break;
        case "with":
          System.out.println("Withdraw");
          System.out.println(accountController.withdraw(sc));
          break;
        case "bal":
          System.out.println("Balance");
          System.out.println(accountController.getBalance(sc));
          break;
        case "rm":
          System.out.println("Cancel Account");
          System.out.println(accountController.delete(sc));
          break;
        case "ls-a":
          System.out.println("Account List");
          accountController.getAccounts().forEach((i)-> {
            System.out.println(i);
          });
          break;
      }
    }


  }
}