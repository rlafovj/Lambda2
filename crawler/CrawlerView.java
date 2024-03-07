package crawler;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
  public static void main(Scanner scanner) throws IOException {
    CrawlerController controller = new CrawlerController();
    while(true){
      System.out.println("[사용자메뉴] 0-종료\n " +
              "1-벅스뮤직\n " +
              "2-로그인\n " +
              "3-ID검색\n " +
              "4-비번변경\n" +
              "5-탈퇴\n " +
              "6-회원목록\n " +
              "7-이름검색\n" +
              "8-직업검색\n" +
              "9-회원수");
      switch (scanner.next()){
        case "0":
          System.out.println("종료");return;
        case "1":
          System.out.println("1-벅스뮤직");
          Map<String, ?> bucks = controller.findBugsMusic(scanner);
          Iterator<Element> rank = (Iterator<Element>) bucks.get("Rank");
          Iterator<Element> artist = (Iterator<Element>) bucks.get("Artist");
          Iterator<Element> title = (Iterator<Element>) bucks.get("Title");
          System.out.println("벅스뮤직 결과 : ");
          while(rank.hasNext()){
            System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
          }
          break;
        case "2":
          System.out.println("2-멜론차트");
          Map<String, ?> melon = controller.findMelonChart(scanner);
          Iterator<Element> rank2 = (Iterator<Element>) melon.get("Rank");
          Iterator<Element> artist2 = (Iterator<Element>) melon.get("Artist");
          Iterator<Element> title2 = (Iterator<Element>) melon.get("Title");
          System.out.println("멜론차트 결과 : ");
          while(rank2.hasNext()){
            System.out.println(rank2.next().text() + "위 " + artist2.next().text() + " - " + title2.next().text());
          }
          break;
        case "3":
          System.out.println("3-ID 검색");

          break;
        case "4":
          System.out.println("4-비번변경");

          break;
        case "5":
          System.out.println("5-탈퇴");

          break;
        case "6":
          System.out.println("6-회원목록");

          break;
        case "7":
          System.out.println("7-이름검색");

          break;
        case "8":
          System.out.println("8-직업검색");

          break;
        case "9":
          System.out.println("9-회원수");


          break;


      }

    }

  }
}