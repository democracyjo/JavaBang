package kosta.mvc.model.dto;
/**
 * 예약관련 클래스
 * reserNo				: int		예약번호(PK)
 * reserDate			: String	예약한날짜 
 * userNo				: int		회원번호(FK) --user_data의 PK
 * checkinDate			: String	 체크인날짜
 * checkoutDate		: String 	체크아웃날짜
 * totalpeopleNum	: int 		총예약인원
 * totalPrice			: int 		가격총합 
 * roomNo				: int 		방번호(FK)--room_data의 PK
 * */
public class Reservation {

	private int reserNo;
	private String reserDate;
	private int userNo;
	private String checkinDate;
	private String checkoutDate;
	private int totalpeopleNum;
	private int totalPrice;
	private int roomNo;
	
	public Reservation() {}

	public Reservation(int reserNo, String reserDate, int userNo, String checkinDate, String checkoutDate,
			int totalpeopleNum, int totalPrice, int roomNo) {
		this.reserNo = reserNo;
		this.reserDate = reserDate;
		this.userNo = userNo;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.totalpeopleNum = totalpeopleNum;
		this.totalPrice = totalPrice;
		this.roomNo = roomNo;
	}

	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	public String getReserDate() {
		return reserDate;
	}

	public void setReserDate(String reserDate) {
		this.reserDate = reserDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getTotalpeopleNum() {
		return totalpeopleNum;
	}

	public void setTotalpeopleNum(int totalpeopleNum) {
		this.totalpeopleNum = totalpeopleNum;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(reserNo+" | ");
		builder.append(reserDate+" | ");
		builder.append(userNo+" | ");
		builder.append(checkinDate+" | ");
		builder.append(checkoutDate+" | ");
		builder.append(totalpeopleNum+" | ");
		builder.append(totalPrice+" | ");
		builder.append(roomNo);
		return builder.toString();
	}

	
}
