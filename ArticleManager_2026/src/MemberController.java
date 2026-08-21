import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController {
  Scanner sc;
  int lastMemberId = 3;
  static List<Member> members;

  public MemberController(Scanner sc) {
    this.sc = sc;
    members = new ArrayList<>();
  }

  public void doJoin() {
    System.out.println("== 회원가입 ==");
    int id = lastMemberId + 1;
    String loginId = null;
    while (true) {
      System.out.print("로그인 아이디 : ");
      loginId = sc.nextLine().trim();
      if (isJoinableLoginId(loginId) == false) {
        System.out.println("이미 사용중인 loginId");
        continue;
      }
      break;
    }
    String password = null;
    while (true) {
      System.out.print("비밀번호 : ");
      password = sc.nextLine().trim();
      System.out.print("비밀번호 확인 : ");
      String passwordConfirm = sc.nextLine().trim();
      if (password.equals(passwordConfirm) == false) {
        System.out.println("비밀번호를 확인하세요.");
        continue;
      }
      break;
    }
  }

  private static boolean isJoinableLoginId(String loginId) {
    for (Member member : members) {
      if (member.getLoginId().equals(loginId)) {
        return false;
      }
    }
    return true;
  }

  public void makeTestData() {
    System.out.println("== 회원 테스트 데이터 생성 ==");
    members.add(new Member(1, Util.getNowStr(), Util.getNowStr(), "test1", "test1", "회원1"));
    members.add(new Member(2, Util.getNowStr(), Util.getNowStr(), "test2", "test2", "회원2"));
    members.add(new Member(3, Util.getNowStr(), Util.getNowStr(), "test3", "test3", "회원3"));
  }
}
