package kosta.mvc.model.dto;
/**
 * 결재관련 클래스
 * payNo			: int		결재번호(PK)
 * payDate		: String	결재일
 * reserNo		: int 		예약번호(FK)--RESERVATION_LIST의 PK
 * */
public class Pay {

	private int payNo;
	private String payDate;
	private int reserNo;
	
	public Pay() {}

	public Pay(int payNo, String payDate, int reserNo) {
		this.payNo = payNo;
		this.payDate = payDate;
		this.reserNo = reserNo;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayNo : "+payNo+" | ");
		builder.append("결제일 : "+payDate+" | ");
		builder.append("예약번호 : "+reserNo+" | ");
		return builder.toString();
	}
	
	
}
