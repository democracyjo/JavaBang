package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsService {
	public List<Room> selectAll() throws SQLException;
	
	public Room searchByRoomNo(int roomNo) throws SQLException;
	/**
	 * 여러 룸타입에 해당하는 방 리스트를 뽑는다.
	 * @param roomType
	 * @return
	 */
	public List<Room> searchByRoomType(List<String> roomType) throws SQLException;
	/**
	 * 최소 사이즈~ 최대 사이즈 사이의 방 리스트를 뽑는다.
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public List<Room> searchByRoomSize(double minSize, double maxSize)throws SQLException;
	/**
	 * 최소가격과 최대가격 사이의 방리스트
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws SQLException;
	/**
	 * 각 층에 대한 방리스트
	 * @param floor
	 * @return
	 */
	public List<Room> searchByFloor(int floor)throws SQLException;
	/**
	 * 각 방의 적정인원수가 min~max사이인것을 구한다.
	 * @param numberPeople
	 * @return
	 */
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople)throws SQLException;
	/**
	 * 침대수가 min~max사이인것을 구한다.
	 * @param minNum
	 * @param maxNum
	 * @return
	 */
	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws SQLException;
	
	public List<Room> searchByBreakfastStat(boolean bfStat) throws SQLException;
}
