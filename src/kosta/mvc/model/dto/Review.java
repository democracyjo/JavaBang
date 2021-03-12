package kosta.mvc.model.dto;

/**
 * 리뷰 관련 클래스 
 * reviewNo			: int		리뷰번호(PK)
 * userNo			: int		회원번호(FK)--user_data의 PK
 * roomNo			: int		방번호(FK)--room_data의 PK
 * score				: int		별점
 * reviewContent			: String	내용
 * reviewDate		: String	등록일
 * */
public class Review {

	private int reviewNo;
	private int userNo;
	private int roomNo;
	private int score;
	private String reviewContent;
	private String reviewDate;
	public Review() {}
	public Review(int reviewNo, int userNo, int roomNo, int score, String content, String reviewDate) {
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.roomNo = roomNo;
		this.score = score;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
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
		builder.append(reviewNo+" | ");
		builder.append(userNo+" | ");
		builder.append(roomNo+" | ");
		builder.append(score+" | ");
		builder.append(reviewContent+" | ");
		builder.append(reviewDate);
		return builder.toString();
	}
	
	
}
