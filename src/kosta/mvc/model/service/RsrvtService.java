package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;

public interface RsrvtService {
	   /**
	    * ���� ����Ʈ�� �߰��ϱ�
	    * */
		 void insertReservation(Reservation rsrvt) throws SQLException;
		 
		 
		 /**
		  * ���ฮ��Ʈ �����ϱ� 
		  * */
		 void reservationDelete(int reserNo) throws SQLException;
		 
		 /**
		  * ���ฮ��Ʈ ��������
		  * */
		 List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;
}
