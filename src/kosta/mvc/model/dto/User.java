package kosta.mvc.model.dto;

public class User {
	// 필드
	private int userNo;
	private String userName;
	private String id;
	private String pw;
	private String ssn;
	private String tel;

	// 생성자
	public User() {}
	public User(String userName, String id, String pw, String ssn, String tel) {
		super();
		this.userName = userName;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		this.tel = tel;
	}

	public User(int userNo, String userName, String id, String pw, String ssn, String tel) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		this.tel = tel;
	}

	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	// get, set
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userName=" + userName + ", id=" + id + ", pw=" + pw + ", ssn=" + ssn
				+ ", tel=" + tel + "]";
	}
}