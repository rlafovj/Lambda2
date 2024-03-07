//package auth;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//public class AuthController {
//    AuthServiceImpl auth;
//
//    private Map<String, ?> users;
//
//    public AuthController() {
//        this.users = new HashMap<>();
//    }
//
//    public String addUser(){
//        return auth.addUsers();
//    }
//    public String save(Scanner sc){
//        auth.save(Member.builder()
//                        .username(sc.next())
//                        .password(sc.next())
//                        .passwordCheck(sc.next())
//                        .name(sc.next())
//                        .residentRegistrationNumber(sc.next())
//                        .phoneNumber(sc.next())
//                        .address(sc.next())
//                        .job(sc.next())
//                        .build());
//        return "회원가입 완료";
//    }
//
//    public String login(Scanner sc){
//        return auth.login(sc);
//    }
//
//    public void findUser(String username){
//        if(users.containsKey(username)){
//            System.out.println(users.get(username));
//        }else System.out.println("입력값과 일치하는 키가 없습니다.");
//    }
//
//    public void printUserList(){
//        users.forEach((key, value) -> {
//            System.out.println(value);
//            System.out.println();
//        });
//    }
//    public String count(){
//        return (auth.count());
//    }
//
//    public String delete(Scanner sc) {
//        auth.delete(Member.builder()
//                .username(sc.next())
//                .build());
//        return "회원 삭제";
//    }
//
//    public String  changePassword(Scanner sc) {
//        return auth.changePassword(sc);
//    }
//
//    public List<?> findByName(Scanner sc) {
//        return auth.findByName(sc);
//    }
//
//    public Map<String, Member> findByJob(Scanner sc) {
//        return null;
//    }
//
//    public Member findByUsername(Scanner sc) {
//        return auth.findByUsername(sc.next());
//    }
//}
//
//
