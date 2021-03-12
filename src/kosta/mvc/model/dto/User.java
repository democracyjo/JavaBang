package kosta.mvc.model.dto;

/**
 * ȸ������ Ŭ����
 * userNo (PK) : int	ȸ����ȣ(������)
 * id				: String	ȸ�����̵�
 * pw				: String	��й�ȣ	
 * ssn			: String	�ֹι�ȣ	
 * tel				: String	��ȭ��ȣ 
 * */

public class User {
	private int userNo;
	private String id;
	private String pw;
	private String ssn;
	private String tel;
	
	public User() {}

	public User(int userNo, String id, String pw, String ssn, String tel) {
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		this.tel = tel;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(userNo+" | ");
		builder.append(id+" | ");
		builder.append(pw+" | ");
		builder.append(ssn+" | ");
		builder.append(tel);
		return builder.toString();
	}
	
	

}
