import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  static List<Article> articles;

  public App() {
    articles = new ArrayList<>();
  }

  public void run() {
    Scanner sc = new Scanner(System.in);
    System.out.println("== 프로그램 시작 ==");
    MemberController memberController = new MemberController(sc);
    ArticleController articleContorller = new ArticleController(sc);

    int lastArticleId = 3;

    articleContorller.makeTestDate();
    memberController.makeTestData();

    while (true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine().trim();

      if (cmd.equals("exit")) {
        break;
      } else if (cmd.length() == 0) {
        System.out.println("명령어를 입력해주세요.");
        continue;
      }
      if (cmd.equals("member join")) {
        memberController.doJoin();
      } else if (cmd.equals("article write")) {
        articleContorller.doWrite();
      } else if (cmd.startsWith("article list")) {
        articleContorller.showList(cmd);
      } else if (cmd.startsWith("article delete")) {
        articleContorller.doDelete(cmd);
      } else if (cmd.startsWith("article modify")) {
        articleContorller.doModify(cmd);
      } else if (cmd.startsWith("article detail")) {
        articleContorller.showDetail(cmd);
      } else {
        System.out.println("사용할 수 없는 명령어 입니다.");
      }
    }
    System.out.println("== 프로그램 종료 ==");
    sc.close();
  }
}



