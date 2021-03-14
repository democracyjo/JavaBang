package kosta.mvc.model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

public interface RsrvtService {
	   /**
	    * ���� ����Ʈ�� �߰��ϱ�
	 * @throws ParseException 
	    * */
		 void insertReservation(Reservation rsrvt, Room room) throws SQLException, ParseException;
		 
		 
		 /**
		  * ���ฮ��Ʈ �����ϱ� 
		  * */
		 void reservationDelete(int reserNo) throws SQLException;
		 
		 /**
		  * ���ฮ��Ʈ ��������
		  * */
		 List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;
}
