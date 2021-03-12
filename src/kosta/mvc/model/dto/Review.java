package kosta.mvc.model.dto;

/**
 * ���� ���� Ŭ���� 
 * reviewNo			: int		�����ȣ(PK)
 * userNo			: int		ȸ����ȣ(FK)--user_data�� PK
 * roomNo			: int		���ȣ(FK)--room_data�� PK
 * score				: int		����
 * reviewContent			: String	����
 * reviewDate		: String	�����
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
