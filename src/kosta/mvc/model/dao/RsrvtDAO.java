package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;

public interface RsrvtDAO {
	
	/**
	   * 예약리스트에 추가하기
	   * 1) RESERVATION_LIST 테이블에 insert
	   * 2) 해당 방 예약가능일 업데이트.
	   * @param Reservation rsrv
	   * @return int 
	   * */
		int reservationInsert(Reservation rsrvt)throws SQLException;
		
		/**
		   * 예약리스트 삭제하기
		   * : RESERVATION_LIST 테이블에서 delete
		   * @param int reserNo
		   * @return int 
		   * */
		int reservationDelete(int reserNo) throws SQLException;
		
		/**
		 * 예약리스트 전체 보기 
		 * @param String userId
		 * @return List<Reservation> 
		 * */
		List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;

}
