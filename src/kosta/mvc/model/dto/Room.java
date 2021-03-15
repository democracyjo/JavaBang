package kosta.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dao.RoomsDAOImpl;

public class Room {

	private int roomNo; // 방번호
	private int roomType; // 방 종류
	private double size; // 방크기
	private int price; // 방가격
	private int floor; // 층수
	private int aprprNmbP; // 적정인원수
	private int numberBeds; // 침대수
	private boolean breakfastStatus; // 조식 가능 여부
	private int prcadPrsn; // 추가인원당 가격
	private String roomTypeSt; // 방 타입 string
	private double avgScore; //평균 평점
	public Room() {
	}

	public Room(int roomNo, int roomType, double size, int price, int floor, int aprprNmbP, int numberBeds,
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
		try {
			this.roomTypeSt = RoomsDAOImpl.getRoomType(roomType);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			this.roomTypeSt = RoomsDAOImpl.getRoomType(roomType);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public boolean isBreakfastStatus() {
		return breakfastStatus;
	}

	public void setBreakfastStatus(boolean breakfastStatus) {
		this.breakfastStatus = breakfastStatus;
	}
	
	public String getRoomTypeSt() {
		return roomTypeSt;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("방번호 : ");
		builder.append(roomNo);
		builder.append(", 방종류 : ");
		builder.append(roomTypeSt);
		builder.append(", 방 크기 : ");
		builder.append(size);
		builder.append(", 일박 가격 : ");
		builder.append(price);
		builder.append(", 층 수 : ");
		builder.append(floor);
		builder.append(", 적정 인원 : ");
		builder.append(aprprNmbP);
		builder.append(", 침대 수 : ");
		builder.append(numberBeds);
		builder.append(", 조식 가능 여부 : ");
		if (breakfastStatus) {
			builder.append("가능");
		} else {
			builder.append("불가");
		}
		builder.append(", 추가 인원 당 가격 : ");
		builder.append(prcadPrsn);
		builder.append(", 평균 평점 : ");
		builder.append(avgScore);

		return builder.toString();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return roomNo;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Room rm= (Room)obj;
		if(this.roomNo==rm.getRoomNo()) {
			return true;
		}else {
			return false;
		}
	}

}
