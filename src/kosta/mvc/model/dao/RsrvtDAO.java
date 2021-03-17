package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

public interface RsrvtDAO {
	
	/**
	   * 예약리스트에 추가하기
	   * 1) RESERVATION_LIST 테이블에 insert
	   * 2) 해당 방 예약가능일 업데이트.
	   * @param Reservation rsrvt
	   * @return  Room room 
	   * @throws SQLException
	   * */
		int reservationInsert(Reservation rsrvt,  Room room)throws SQLException;
		
		/**
		   * 예약리스트 삭제하기
		   * : RESERVATION_LIST 테이블에서 delete
		   * @param int reserNo
		   * @return int 
		   * @throws SQLException
		   * */
		int reservationDelete(int reserNo) throws SQLException;
		
		/**
		 * 예약리스트 전체 보기 (아이디로)
		 * @param String userId
		 * @return List<Reservation> 
		 * @throws SQLException
		 * */
		List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;
		
		/**
		 * 모든 회원 예약리스트 보기
		 * @return List<Reservation>
		 * */
		List<Reservation> selectRsrvtAll() throws SQLException;
		
		/**
		 * 방넘버로 예약리스트 확인하기 
		 * @param int RoomNo
		 * @return List<Reservation>
		 * @throws SQLException
		 * */
		List<Reservation> selectRsrvtByRoomNo(int RoomNo)throws SQLException;
}
