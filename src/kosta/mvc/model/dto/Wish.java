package kosta.mvc.model.dto;
/**
 *관심리스트 관련 클래스
 *wishNo		: int		관심번호(PK)
 *userNo		: int		회원번호--user_data의 PK
 *roomNo		: int		방번호--room_data의 PK
 *wishDate		: String	찜등록일
 * */
public class Wish {

	private int wishNo;
	private int userNo;
	private int roomNo;
	private String wishDate;
	public Wish() {}
	public Wish(int wishNo, int userNo, int roomNo, String wishDate) {
		this.wishNo = wishNo;
		this.userNo = userNo;
		this.roomNo = roomNo;
		this.wishDate = wishDate;
	}
	public int getWishNo() {
		return wishNo;
	}
	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
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
	public String getWishDate() {
		return wishDate;
	}
	public void setWishDate(String wishDate) {
		this.wishDate = wishDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(wishNo+" | ");
		builder.append(userNo+" | ");
		builder.append(roomNo+" | ");
		builder.append(wishDate);
		return builder.toString();
	}
	
	
	
}
