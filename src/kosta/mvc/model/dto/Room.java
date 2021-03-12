package kosta.mvc.model.dto;


import java.util.ArrayList;
import java.util.List;



public class Room{

	private int roomNo; // 방번호
	private int roomType; //방 종류
	private double size; // 방크기
	private int price; // 방가격
	private String floor; // 층수
	private int aprprNmbP;
	private int numberBeds;
	private boolean breakfastStatus;
	private int prcadPrsn; //추가인원당 가격
	
	

	private List<Review> reviewList = new ArrayList<>();
	
	


	public Room(int roomNo, int roomType, double size, int price, String floor, int aprprNmbP, int numberBeds,
			boolean breakfastStatus, int prcadPrsn) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.size = size;
		this.price = price;
		this.floor = floor;
		this.aprprNmbP = aprprNmbP;
		this.numberBeds = numberBeds;
		this.breakfastStatus = breakfastStatus;
		this.prcadPrsn = prcadPrsn;
	}
	
	
	public int getAprprNmbP() {
		return aprprNmbP;
	}

	public void setAprprNmbP(int aprprNmbP) {
		this.aprprNmbP = aprprNmbP;
	}

	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
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
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public int getNumberBeds() {
		return numberBeds;
	}
	public void setNumberBeds(int numberBeds) {
		this.numberBeds = numberBeds;
	}
	public int getPrcadPrsn() {
		return prcadPrsn;
	}
	public void setPrcadPrsn(int prcadPrsn) {
		this.prcadPrsn = prcadPrsn;
	}
	public boolean isBreakfastStatus() {
		return breakfastStatus;
	}

	public void setBreakfastStatus(boolean breakfastStatus) {
		this.breakfastStatus = breakfastStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [roomNo=");
		builder.append(roomNo);
		builder.append(", roomType=");
		builder.append(roomType);
		builder.append(", size=");
		builder.append(size);
		builder.append(", price=");
		builder.append(price);
		builder.append(", floor=");
		builder.append(floor);
		builder.append(", numberBeds=");
		builder.append(numberBeds);
		builder.append(", breakfastStatus=");
		builder.append(breakfastStatus);
		builder.append(", prcadPrsn=");
		builder.append(prcadPrsn);
		builder.append("]");
		return builder.toString();
	}

	
}
