package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsService {
	public List<Room> selectAll();
	
	public Room searchByRoomNo(int roomNo);
	/**
	 * ���� ��Ÿ�Կ� �ش��ϴ� �� ����Ʈ�� �̴´�.
	 * @param roomType
	 * @return
	 */
	public List<Room> searchByRoomType(List<String> roomType);
	/**
	 * �ּ� ������~ �ִ� ������ ������ �� ����Ʈ�� �̴´�.
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public List<Room> searchByRoomSize(int minSize, int maxSize);
	/**
	 * �ּҰ��ݰ� �ִ밡�� ������ �渮��Ʈ
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice);
	/**
	 * �� ���� ���� �渮��Ʈ
	 * @param floor
	 * @return
	 */
	public List<Room> searchByFloor(int floor);
	/**
	 * �� ���� �����ο����� min~max�����ΰ��� ���Ѵ�.
	 * @param numberPeople
	 * @return
	 */
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople);
	/**
	 * ħ����� min~max�����ΰ��� ���Ѵ�.
	 * @param minNum
	 * @param maxNum
	 * @return
	 */
	public List<Room> searchByNumberBeds(int minNum, int maxNum);
	/**
	 * ħ�� ��������� ������� �ű� �ش��ϴ°� ���Ѵ�.
	 * @param BedSize
	 * @return
	 */
	public List<Room> searchByBedSize(List<String> BedSize);
}
