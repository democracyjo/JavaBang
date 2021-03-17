package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsDAO {
		/**
	 * 전체 룸 리스트를 가져온다.
	 * @return
	 * @throws SQLException
	 */
	public List<Room> selectAll() throws SQLException;
	/**
	 * 방 번호로 방을 검색
	 * @param roomNo
	 * @return
	 * @throws SQLException
	 */
	public Room searchByRoomNo(int roomNo)throws SQLException;
	/**
	 * 방 타입의 리스트로 방을 검색
	 * @param roomType
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByRoomType(List<String> roomType)throws SQLException;
	/**
	 * 최소 사이즈와 최대사이즈를 만족하는 방사이즈를 검색
	 * @param minSize
	 * @param maxSize
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByRoomSize(double minSize, double maxSize)throws SQLException;
	/**
	 * 최소가격~ 최대가격 사이의 방을 검색
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws SQLException;
	/**
	 * 최소 층 ~ 최대층 사이의 방을 검색
	 * @param minFloor
	 * @param maxFloor
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByFloor(int minFloor, int maxFloor)throws SQLException;
	/**
	 * 최소 적정사람수~최대 적정사람수인 방을 검색
	 * @param minNum
	 * @param maxNum
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByNumberPeople(int minNum, int maxNum)throws SQLException;
	/**
	 * 최소 침대수 ~ 최대 침대수 사이인 방을 검색
	 * @param minNum
	 * @param maxNum
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws SQLException;
	/**
	 * 조식 여부를 기준으로 검색
	 * @param bfStat
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByBreakfastStat(boolean bfStat) throws SQLException;
	/**
	 * 체크인, 체크아웃 날짜를 기준으로 예약가능한 방을 검색
	 * @param checkinDate
	 * @param checkoutDate
	 * @return
	 * @throws SQLException
	 */
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws SQLException;
	/**
	 * 방번호를 기준으로 평균 평점 업데이트 
	 * @param roomNo
	 * @throws SQLException
	 */
	public void upDateAvgScroe(int roomNo) throws SQLException;
	/**
	 * 리뷰번호를 기준으로 평균 평점 업데이트
	 * @param reviewNo
	 * @throws SQLException
	 */
	public void updateAvgByRevNo(int reviewNo) throws SQLException;
}
