package com.linus.api.user;

import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) throws SQLException {
        UserController controller = new UserController();
        String msg = controller.addUsers();
        System.out.println(" addUsers 결과 : "+msg);
        while(true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-회원가입\n " +
                    "2-로그인\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "ls-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수\n" +
                    "touch-테이블 생성\n" +
                    "rm-테이블 삭제\n" +
                    "");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-회원가입");
                    msg = controller.save(sc);
                    System.out.println("회원가입 결과 : "+msg);
                    break;
                case "2":
                    System.out.println("2-로그인");
                    msg = controller.login(sc);
                    System.out.println("로그인 결과 : "+msg);
                    break;
                case "3":
                    System.out.println("3-ID 검색");
                    System.out.println(controller.getOne(sc));
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println(controller.updatePassword(sc));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println(controller.delete(sc));
                    break;
                case "ls":
                    System.out.println("6-회원목록");
                    controller.findUsers();
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    controller.findUsersByName(sc).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    controller.findUsersByJob(sc).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("9-회원수");
                    String numberOfUsers = String.valueOf(controller.count());
                    System.out.println("회원수 "+numberOfUsers);
                    break;
                case "touch":
                    System.out.println("테이블 생성");
                    controller.touchTable();
                    System.out.println("테이블 생성 성공");
                    break;
                case "rm":
                    System.out.println("테이블 삭제");
                    controller.removeTable(sc);
                    System.out.println("테이블 삭제 성공");
                    break;

            }
        }
    }
}