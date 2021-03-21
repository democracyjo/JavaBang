package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

/**
 * 예약리스트에 예약정보 등록/삭제/검색 기능
 * 방을 예약하고, 예약한 방을 검색 또는 예약취소하는 용도
 * 
 * @author Minjoo Jo
 * @version 1.0
 * */
public interface RsrvtDAO {
	
	/**
	   * 예약리스트에 추가하기
	   * 1) RESERVATION_LIST 테이블에 insert
	   * 2) 해당 방 예약가능일 업데이트.
	   * @param Reservation rsrvt
	   * @return  Room room 
	   * @throws SQLException, ParseException
	   * */
		int reservationInsert(Reservation rsrvt,  Room room)throws SQLException, ParseException;
		
		/**
		   * 예약번호로 예약리스트에서 예약 삭제하기
		   * : RESERVATION_LIST 테이블에서 delete
		   * @param int reserNo
		   * @return int 
		   * @throws SQLException
		   * */
		int reservationDelete(int reserNo) throws SQLException;
		
		/**
		 * 해당 아이디로 예약리스트 전체 보기 
		 * @param String userId
		 * @return List<Reservation>  : 예약정보 보여줌
		 * @throws SQLException
		 * */
		List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;
		
		/**
		 * 모든 회원의 예약리스트 보기
		 * @return List<Reservation>
		 * */
		List<Reservation> selectRsrvtAll() throws SQLException;
		
		/**
		 * 방번호로 예약리스트 확인하기 
		 * :해당 방의 예약상태를 보여주는 용도
		 * @param int RoomNo
		 * @return List<Reservation>
		 * @throws SQLException
		 * */
		List<Reservation> selectRsrvtByRoomNo(int RoomNo)throws SQLException;
}
