package kosta.mvc.model.dto;
/**
 * ������� Ŭ����
 * payNo			: int		�����ȣ(PK)
 * payDate		: String	������
 * reserNo		: int 		�����ȣ(FK)--RESERVATION_LIST�� PK
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
		builder.append("������ : "+payDate+" | ");
		builder.append("�����ȣ : "+reserNo+" | ");
		return builder.toString();
	}
	
	
}
