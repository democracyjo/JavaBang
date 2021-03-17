package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsDAO {
		/**
	 * ��ü �� ����Ʈ�� �����´�.
	 * @return
	 * @throws SQLException
	 */
	public List<Room> selectAll() throws SQLException;
	/**
	 * �� ��ȣ�� ���� �˻�
	 * @param roomNo
	 * @return
	 * @throws SQLException
	 */
	public Room searchByRoomNo(int roomNo)throws SQLException;
	/**
	 * �� Ÿ���� ����Ʈ�� ���� �˻�
	 * @param roomType
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByRoomType(List<String> roomType)throws SQLException;
	/**
	 * �ּ� ������� �ִ����� �����ϴ� ������ �˻�
	 * @param minSize
	 * @param maxSize
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByRoomSize(double minSize, double maxSize)throws SQLException;
	/**
	 * �ּҰ���~ �ִ밡�� ������ ���� �˻�
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws SQLException;
	/**
	 * �ּ� �� ~ �ִ��� ������ ���� �˻�
	 * @param minFloor
	 * @param maxFloor
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByFloor(int minFloor, int maxFloor)throws SQLException;
	/**
	 * �ּ� ���������~�ִ� ����������� ���� �˻�
	 * @param minNum
	 * @param maxNum
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByNumberPeople(int minNum, int maxNum)throws SQLException;
	/**
	 * �ּ� ħ��� ~ �ִ� ħ��� ������ ���� �˻�
	 * @param minNum
	 * @param maxNum
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws SQLException;
	/**
	 * ���� ���θ� �������� �˻�
	 * @param bfStat
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByBreakfastStat(boolean bfStat) throws SQLException;
	/**
	 * üũ��, üũ�ƿ� ��¥�� �������� ���డ���� ���� �˻�
	 * @param checkinDate
	 * @param checkoutDate
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws SQLException;
	/**
	 * ���ȣ�� �������� ��� ���� ������Ʈ 
	 * @param roomNo
	 * @throws SQLException
	 */
	public void upDateAvgScroe(int roomNo) throws SQLException;
	/**
	 * �����ȣ�� �������� ��� ���� ������Ʈ
	 * @param reviewNo
	 * @throws SQLException
	 */
	public void updateAvgByRevNo(int reviewNo) throws SQLException;
}
