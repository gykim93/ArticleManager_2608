import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 게시글 수정 => setter 활용.
// 게시글 상세보기
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
        } //"article delete 3"
      } else if (cmd.startsWith("article delete")) {
        System.out.println("== 게시글 삭제 ==");
        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = null;
        for (Article article : articles) {
          if (article.getId() == id) {
            foundArticle = article;
            break;
          }
        }
        if (foundArticle == null) {
          System.out.println("해당 게시글은 없습니다.");
          continue;
        }
        articles.remove(foundArticle);
        System.out.println(id + "번 게시글이 삭제되었습니다.");
      } else if (cmd.startsWith("article modify")) {
        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = null;
        for (Article article : articles) {
          if (article.getId() == id) {
            foundArticle = article;
            break;
          }
        }
        if (foundArticle == null) {
          System.out.println("해당 게시글은 없습니다.");
          continue;
        }
        System.out.println("기존 title : " + foundArticle.getTitle());
        System.out.println("기존 body : " + foundArticle.getBody());

        System.out.print("새 제목 : ");
        String newTitle = sc.nextLine().trim();

        System.out.print("새 내용 : ");
        String newBody = sc.nextLine().trim();

        foundArticle.setTitle(newTitle);
        foundArticle.setBody(newBody);
        System.out.println(id + "번 게시글이 수정되었습니다.");
      } else if (cmd.startsWith("article detail")) {
        System.out.println("== 게시글 상세보기 ==");
        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = null;
        for (Article article : articles) {
          if (article.getId() == id) {
            foundArticle = article;
            break;
          }
        }
        if (foundArticle == null) {
          System.out.println("해당 게시글은 없습니다.");
          continue;
        }
        System.out.println("번호 : " + foundArticle.getId());
        System.out.println("제목 : " + foundArticle.getTitle());
        System.out.println("내용 : " + foundArticle.getBody());
      } else {
        System.out.println("사용할 수 없는 명령어 입니다.");
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

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setBody(String body) {
    this.body = body;
  }


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