import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("== 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);
    int lastArticleId = 0;

    List<Article> articles = new ArrayList<>();

    while (true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine().trim();

      if (cmd.equals("exit")) {
        break;
      } else if (cmd.length() == 0) {
        System.out.println("명령어를 입력해주세요.");
        continue;
      }
      if (cmd.equals("article write")) {
        System.out.println("== 게시글 작성 ==");
        int id = lastArticleId + 1;
        System.out.print("제목 : ");
        String title = sc.nextLine().trim();

        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        Article article = new Article(id, title, body);
        articles.add(article);

        System.out.printf("%d번 글이 작성되었습니다.\n", id);
        lastArticleId++;
      } else if (cmd.equals("article list")) {
        System.out.println("== 게시물 목록 ==");
        if (articles.size() == 0) {
          System.out.println("게시글이 존재하지 않습니다.");
        } else {
          System.out.println("  번호  /  제목  /  내용  ");
          for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);
            System.out.printf("  %d  /  %s  /  %s  \n", article.getId(), article.getTitle(), article.getBody());
          }
        }
      }
    }
    System.out.println("== 프로그램 종료 ==");
    sc.close();
  }
}

class Article {
  private int id;
  private String title;
  private String body;

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public Article(int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }
}