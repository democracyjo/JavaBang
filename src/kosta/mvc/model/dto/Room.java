package kosta.mvc.model.dto;

/**
 * �� ���� Ŭ����
 * roomNo (PK) : int	���ȣ(������)
 * roomType	  : String	������
 * size			  : double ��ũ��	
 * price		      : int	�Ϲ� ����	
 * floor			  : int	������ 
 * mxmmPrsnl	  : int	�ִ��ο� 
 * numberBeds  : int	ħ��� 
 * bedSize		  : String	ħ������� 
 * prcadPrsn     : int �߰��ο��簡��
 * */
public class Room {
	private int roomNo;
	private String roomType;
	private double size;
	private int price;
	private int floor;
	private int mxmmPrsnl;
	private int numberBeds;
	private String bedSize;
	private int prcadPrsn;
	
	public Room() {}

	public Room(int roomNo, String roomType, double size, int price, int floor, int mxmmPrsnl, int numberBeds,
			String bedSize, int prcadPrsn) {
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.size = size;
		this.price = price;
		this.floor = floor;
		this.mxmmPrsnl = mxmmPrsnl;
		this.numberBeds = numberBeds;
		this.bedSize = bedSize;
		this.prcadPrsn = prcadPrsn;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getMxmmPrsnl() {
		return mxmmPrsnl;
	}

	public void setMxmmPrsnl(int mxmmPrsnl) {
		this.mxmmPrsnl = mxmmPrsnl;
	}

	public int getNumberBeds() {
		return numberBeds;
	}

	public void setNumberBeds(int numberBeds) {
		this.numberBeds = numberBeds;
	}

	public String getBedSize() {
		return bedSize;
	}

	public void setBedSize(String bedSize) {
		this.bedSize = bedSize;
	}

	public int getPrcadPrsn() {
		return prcadPrsn;
	}

	public void setPrcadPrsn(int prcadPrsn) {
		this.prcadPrsn = prcadPrsn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(roomNo+" | ");
		builder.append(roomType+" | ");
		builder.append(size+" | ");
		builder.append(price+" | ");
		builder.append(floor+" | ");
		builder.append(mxmmPrsnl+" | ");
		builder.append(numberBeds+" | ");
		builder.append(bedSize+" | ");
		builder.append(prcadPrsn);
		return builder.toString();
	}
	
	
	
}
