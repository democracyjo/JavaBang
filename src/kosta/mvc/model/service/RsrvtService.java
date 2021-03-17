package kosta.mvc.model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.User;

public interface RsrvtService {
	   /**
	    * ���� ����Ʈ�� �߰��ϱ�
	    * @param Reservation rsrvt, int roomNo
	    * @throws SQLException,ParseException 
	    * */
		 void insertReservation(Reservation rsrvt, int roomNo) throws SQLException, ParseException;
		 
		 
		 /**
		  * ���ฮ��Ʈ �����ϱ� 
		  * @param int reserNo
		  * @throws SQLException
		  * */
		 void reservationDelete(int reserNo) throws SQLException;
		 
		 /**
		  * ���ฮ��Ʈ ��������
		  * @param String userId
		  * @return  List<Reservation>
		  * @throws SQLException
		  * */
		 List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;


		 /**
		  * üũ��/�ƿ� ��ȿ��üũ
		  * :üũ�ƿ���¥�� üũ�γ�¥���� ������ ���� üũ
		  * @param String begin, String end
		  * @return boolean ������ true, ������ false
		  * @throws SQLException
		  * */
		public boolean diffOfDate(String begin, String end) throws SQLException;
		
		/**
		 * �����ȣ üũ
		 * : �ش� UserId�� �ش� �����ȣ�� ������ �ִ��� ���� üũ
		 * @param User user, int reserNo
		 * @return boolean �����ȣ������ true, ������ false
		 * @throws SQLException
		 * */
		boolean hasReserNo(User user, int reserNo) throws SQLException;
}

