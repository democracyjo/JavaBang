package kosta.mvc.model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.User;

public interface RsrvtService {
	   /**
	    * ���� ����Ʈ�� �߰��ϱ�
	 * @throws ParseException 
	    * */
		 void insertReservation(Reservation rsrvt, int roomNo) throws SQLException, ParseException;
		 
		 
		 /**
		  * ���ฮ��Ʈ �����ϱ� 
		  * */
		 void reservationDelete(int reserNo) throws SQLException;
		 
		 /**
		  * ���ฮ��Ʈ ��������
		  * */
		 List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;


		 /**
		  * üũ��/�ƿ� ��ȿ��üũ
		  * */
		public boolean diffOfDate(String begin, String end) throws SQLException;
		
		/**
		 * �����ȣ üũ
		 * */
		boolean hasReserNo(User user, int reserNo) throws SQLException;
}

