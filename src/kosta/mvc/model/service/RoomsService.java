package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsService {
	public List<Room> selectAll() throws SQLException;
	
	public Room searchByRoomNo(int roomNo) throws SQLException;
	/**
	 * ���� ��Ÿ�Կ� �ش��ϴ� �� ����Ʈ�� �̴´�.
	 * @param roomType
	 * @return
	 */
	public List<Room> searchByRoomType(List<String> roomType) throws SQLException;
	/**
	 * �ּ� ������~ �ִ� ������ ������ �� ����Ʈ�� �̴´�.
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public List<Room> searchByRoomSize(double minSize, double maxSize)throws SQLException;
	/**
	 * �ּҰ��ݰ� �ִ밡�� ������ �渮��Ʈ
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws SQLException;
	/**
	 * �� ���� ���� �渮��Ʈ
	 * @param floor
	 * @return
	 */
	public List<Room> searchByFloor(int floor)throws SQLException;
	/**
	 * �� ���� �����ο����� min~max�����ΰ��� ���Ѵ�.
	 * @param numberPeople
	 * @return
	 */
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople)throws SQLException;
	/**
	 * ħ����� min~max�����ΰ��� ���Ѵ�.
	 * @param minNum
	 * @param maxNum
	 * @return
	 */
	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws SQLException;
	
	public List<Room> searchByBreakfastStat(boolean bfStat) throws SQLException;
}
