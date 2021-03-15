package kosta.mvc.model.dto;

/**
 * 리뷰 관련 클래스 reviewNo : int 리뷰번호(PK) userNo : int 회원번호(FK)--user_data의 PK roomNo
 * : int 방번호(FK)--room_data의 PK score : int 별점 reviewContent : String 내용
 * reviewDate : String 등록일
 */
public class Review {

	private int reviewNo;
	private int userNo;
	private int roomNo;
	private int score;
	private String reviewContent;
	private String reviewDate;

	public Review() {
	}

	public Review(int reviewNo, int userNo, int roomNo, int score, String reviewContent, String reviewDate) {
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.roomNo = roomNo;
		this.score = score;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}

	public Review(int reviewNo, String reviewContent) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("리뷰번호 : " + reviewNo + " | ");
		builder.append("유저번호 : " + userNo + " | ");
		builder.append("방번호 : " + roomNo + " | ");
		builder.append("평점 : " + score + " | ");
		builder.append("리뷰내용 : " + reviewContent + " | ");
		builder.append("리뷰날짜 : " + reviewDate);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return userNo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Review rv=(Review)obj;
		return rv.getRoomNo()==roomNo&&rv.getUserNo()==userNo;
	}

}
