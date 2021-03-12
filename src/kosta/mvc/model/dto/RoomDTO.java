package kosta.mvc.model.dto;

import java.util.ArrayList;

import java.util.List;



public class RoomDTO {

	private int roomNo; // 방번호
	private String roomType; //방 종류
	private double size; // 방크기
	private int price; // 방가격
	private String floor; // 층수
	private int numberBeds;
	private String bedSize;
	private int prcadPrsn; //추가인원당 가격
	
	private List<Review> orderLineList = new ArrayList<>();
	
	public RoomDTO(int roomNo, String roomType, double size, int price, String floor, int numberBeds, String bedSize,
			int prcadPrsn) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.size = size;
		this.price = price;
		this.floor = floor;
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
		builder.append("RoomDTO [roomNo=");
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
		builder.append(", bedSize=");
		builder.append(bedSize);
		builder.append(", prcadPrsn=");
		builder.append(prcadPrsn);
		builder.append("]");
		return builder.toString();
	}
	
}
