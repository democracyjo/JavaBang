package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;

public interface RsrvtController {
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
		 void selectRsrvtByUserId(String userId)throws SQLException;
}




