package kosta.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dao.RoomsDAOImpl;

public class Room {

	private int roomNo; // ���ȣ
	private int roomType; // �� ����
	private double size; // ��ũ��
	private int price; // �氡��
	private int floor; // ����
	private int aprprNmbP; // �����ο���
	private int numberBeds; // ħ���
	private boolean breakfastStatus; // ���� ���� ����
	private int prcadPrsn; // �߰��ο��� ����
	private String roomTypeSt; // �� Ÿ�� string
	private double avgScore; //��� ����
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
		builder.append("���ȣ : ");
		builder.append(roomNo);
		builder.append(", ������ : ");
		builder.append(roomTypeSt);
		builder.append(", �� ũ�� : ");
		builder.append(size);
		builder.append(", �Ϲ� ���� : ");
		builder.append(price);
		builder.append(", �� �� : ");
		builder.append(floor);
		builder.append(", ���� �ο� : ");
		builder.append(aprprNmbP);
		builder.append(", ħ�� �� : ");
		builder.append(numberBeds);
		builder.append(", ���� ���� ���� : ");
		if (breakfastStatus) {
			builder.append("����");
		} else {
			builder.append("�Ұ�");
		}
		builder.append(", �߰� �ο� �� ���� : ");
		builder.append(prcadPrsn);
		builder.append(", ��� ���� : ");
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
