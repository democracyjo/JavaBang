package kosta.mvc.model.service;


import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsService {
	/**
	 * 전체 방을 검색
	 * @return
	 * @throws Exception
	 */
	public List<Room> selectAll() throws Exception;
	/**
	 * 방번호를 기준으로 방을 검색
	 * @param roomNo
	 * @return
	 * @throws Exception
	 */
	public Room searchByRoomNo(int roomNo) throws Exception;
	/**
	 * 여러 룸타입에 해당하는 방 리스트를 뽑는다.
	 * @param roomType
	 * @return
	 */
	public List<Room> searchByRoomType(List<String> roomType) throws Exception;
	/**
	 * 최소 사이즈~ 최대 사이즈 사이의 방 리스트를 뽑는다.
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public List<Room> searchByRoomSize(double minSize, double maxSize)throws Exception;
	/**
	 * 최소가격과 최대가격 사이의 방리스트
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws Exception;
	/**
	 * 각 층에 대한 방리스트
	 * @param floor
	 * @return
	 */
	public List<Room> searchByFloor(int minFloor,int maxFloor)throws Exception;
	/**
	 * 각 방의 적정인원수가 min~max사이인것을 구한다.
	 * @param numberPeople
	 * @return
	 */
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople)throws Exception;
	/**
	 * 침대수가 min~max사이인것을 구한다.
	 * @param minNum
	 * @param maxNum
	 * @return
	 */
	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws Exception;
	
	public List<Room> searchByBreakfastStat(boolean bfStat) throws Exception;
	
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws Exception;
}
