package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

public interface RsrvtService {
	   /**
	    * 예약 리스트에 추가하기
	    * */
		 void insertReservation(Reservation rsrvt, Room room) throws SQLException;
		 
		 
		 /**
		  * 예약리스트 삭제하기 
		  * */
		 void reservationDelete(int reserNo) throws SQLException;
		 
		 /**
		  * 예약리스트 내역보기
		  * */
		 List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;
}
