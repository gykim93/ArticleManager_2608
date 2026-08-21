import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
  Scanner sc;
  int lastArticleId = 3;
  static List<Article> articles;

  public ArticleController(Scanner sc) {
    this.sc = sc;
    articles = new ArrayList<>();
  }

  // 게시글 작성 함수 구현
  public void doWrite() {
    System.out.println("== 게시글 작성 ==");

    int id = lastArticleId + 1;
    System.out.print("제목 : ");
    String title = sc.nextLine().trim();

    System.out.print("내용 : ");
    String body = sc.nextLine().trim();

    String regDate = Util.getNowStr();
    String updateDate = Util.getNowStr();

    Article article = new Article(id, regDate, updateDate, title, body);
    articles.add(article);

    System.out.printf("%d번 글이 작성되었습니다.\n", id);
    lastArticleId++;
  }

  // 게시글 목록 함수 구현
  public void showList(String cmd) {
    System.out.println("== 게시물 목록 ==");
    if (articles.size() == 0) {
      System.out.println("게시글이 존재하지 않습니다.");
      return;
    }
    String searchKeyword = cmd.substring("article list".length()).trim(); // article list 제목

    List<Article> forPrintArticles = articles;
    if (searchKeyword.length() > 0) {
      System.out.println("검색어 : " + searchKeyword);
      forPrintArticles = new ArrayList<>();

      for (Article article : articles) {
        if (article.getTitle().contains(searchKeyword)) {
          forPrintArticles.add(article);
        }
      }
      if (forPrintArticles.size() == 0) {
        System.out.println("검색 결과 없음");
        return;
      }
    }
    System.out.println("  번호  /  날짜  /  제목  /  내용  ");
    for (int i = forPrintArticles.size() - 1; i >= 0; i--) {
      Article article = forPrintArticles.get(i);
      if (Util.getNowStr().split(" ")[0].equals(article.getRegDate().split(" ")[0])) {
        System.out.printf("  %d  /  %s  /  %s  /  %s  \n", article.getId(), article.getRegDate().split(" ")[1], article.getTitle(), article.getBody());
      } else {
        System.out.printf("  %d  /  %s  /  %s  /  %s  \n", article.getId(), article.getRegDate().split(" ")[0], article.getTitle(), article.getBody());
      }
    }
  }

  // 게시글 상세보기 함수 구현
  public void showDetail(String cmd) {
    System.out.println("== 게시글 상세보기 ==");
    int id = Integer.parseInt(cmd.split(" ")[2]);

    Article foundArticle = getArticleById(id);

    if (foundArticle == null) {
      System.out.println("해당 게시글은 없습니다.");
      return;
    }
    System.out.println("번호 : " + foundArticle.getId());
    System.out.println("작성날짜 : " + foundArticle.getRegDate());
    System.out.println("수정날짜 : " + foundArticle.getUpdateDate());
    System.out.println("제목 : " + foundArticle.getTitle());
    System.out.println("내용 : " + foundArticle.getBody());
  }

  // 게시글 삭제 함수 구현
  public void doDelete(String cmd) {
    System.out.println("== 게시글 삭제 ==");
    int id = Integer.parseInt(cmd.split(" ")[2]);

    Article foundArticle = getArticleById(id);
    if (foundArticle == null) {
      System.out.println("해당 게시글은 없습니다.");
      return;
    }
    articles.remove(foundArticle);
    System.out.println(id + "번 게시글이 삭제되었습니다.");
  }

  // 게시글 수정 함수 구현
  public void doModify(String cmd) {
    System.out.println("== 게시글 수정 ==");
    int id = Integer.parseInt(cmd.split(" ")[2]);

    Article foundArticle = getArticleById(id);

    if (foundArticle == null) {
      System.out.println("해당 게시글은 없습니다.");
      return;
    }
    System.out.println("기존 title : " + foundArticle.getTitle());
    System.out.println("기존 body : " + foundArticle.getBody());

    System.out.print("새 제목 : ");
    String newTitle = sc.nextLine().trim();

    System.out.print("새 내용 : ");
    String newBody = sc.nextLine().trim();

    foundArticle.setTitle(newTitle);
    foundArticle.setBody(newBody);

    foundArticle.setUpdateDate(Util.getNowStr());
    System.out.println(id + "번 게시글이 수정되었습니다.");
  }

  private static Article getArticleById(int id) {
    for (Article article : articles) {
      if (article.getId() == id) {
        return article;
      }
    }
    return null;
  }

  public void makeTestDate() {
    System.out.println("== 테스트 데이터 생성 ==");
    articles.add(new Article(1, "2026-08-14 18:06:00", "2026-08-17 17:00:01", "제목1", "내용1"));
    articles.add(new Article(2, Util.getNowStr(), Util.getNowStr(), "제목2", "내용2"));
    articles.add(new Article(3, Util.getNowStr(), Util.getNowStr(), "제목3", "내용3"));
  }
}


