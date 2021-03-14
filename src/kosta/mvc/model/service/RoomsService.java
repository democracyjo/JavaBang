package kosta.mvc.model.service;


import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsService {
	public List<Room> selectAll() throws Exception;
	
	public Room searchByRoomNo(int roomNo) throws Exception;
	/**
	 * ���� ��Ÿ�Կ� �ش��ϴ� �� ����Ʈ�� �̴´�.
	 * @param roomType
	 * @return
	 */
	public List<Room> searchByRoomType(List<String> roomType) throws Exception;
	/**
	 * �ּ� ������~ �ִ� ������ ������ �� ����Ʈ�� �̴´�.
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public List<Room> searchByRoomSize(double minSize, double maxSize)throws Exception;
	/**
	 * �ּҰ��ݰ� �ִ밡�� ������ �渮��Ʈ
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws Exception;
	/**
	 * �� ���� ���� �渮��Ʈ
	 * @param floor
	 * @return
	 */
	public List<Room> searchByFloor(int floor)throws Exception;
	/**
	 * �� ���� �����ο����� min~max�����ΰ��� ���Ѵ�.
	 * @param numberPeople
	 * @return
	 */
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople)throws Exception;
	/**
	 * ħ����� min~max�����ΰ��� ���Ѵ�.
	 * @param minNum
	 * @param maxNum
	 * @return
	 */
	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws Exception;
	
	public List<Room> searchByBreakfastStat(boolean bfStat) throws Exception;
	
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws Exception;
}
