package kosta.mvc.model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.User;

public interface RsrvtService {
	   /**
	    * 예약 리스트에 추가하기
	    * @param Reservation rsrvt, int roomNo
	    * @throws SQLException,ParseException 
	    * */
		 void insertReservation(Reservation rsrvt, int roomNo) throws SQLException, ParseException;
		 
		 
		 /**
		  * 예약리스트 삭제하기 
		  * @param int reserNo
		  * @throws SQLException
		  * */
		 void reservationDelete(int reserNo) throws SQLException;
		 
		 /**
		  * 예약리스트 내역보기
		  * @param String userId
		  * @return  List<Reservation>
		  * @throws SQLException
		  * */
		 List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;


		 /**
		  * 체크인/아웃 유효성체크
		  * :체크아웃날짜가 체크인날짜보다 늦은지 여부 체크
		  * @param String begin, String end
		  * @return boolean 늦으면 true, 빠르면 false
		  * @throws SQLException
		  * */
		public boolean diffOfDate(String begin, String end) throws SQLException;
		
		/**
		 * 예약번호 체크
		 * : 해당 UserId가 해당 예약번호를 가지고 있는지 여부 체크
		 * @param User user, int reserNo
		 * @return boolean 예약번호있으면 true, 없으면 false
		 * @throws SQLException
		 * */
		boolean hasReserNo(User user, int reserNo) throws SQLException;
}

