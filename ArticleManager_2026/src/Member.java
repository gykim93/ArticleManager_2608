public class Member {
  private int id;
  private String regDate;
  private String updateDate;
  private String loginId;
  private String loginPw;
  private String name;


  public Member(int id, String regDate, String updateDate, String loginId, String loginPw, String name) {
    this.id = id;
    this.regDate = regDate;
    this.updateDate = updateDate;
    this.loginId = loginId;
    this.loginPw = loginPw;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getRegDate() {
    return regDate;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public String getLoginId() {
    return loginId;
  }

  public String getLoginPw() {
    return loginPw;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public void setLoginPw(String loginPw) {
    this.loginPw = loginPw;
  }

  public void setName(String name) {
    this.name = name;
  }
}
