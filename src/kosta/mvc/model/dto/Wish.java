package kosta.mvc.model.dto;
/**
 *���ɸ���Ʈ ���� Ŭ����
 *wishNo		: int		���ɹ�ȣ(PK)
 *userNo		: int		ȸ����ȣ--user_data�� PK
 *roomNo		: int		���ȣ--room_data�� PK
 *wishDate		: String	������
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
