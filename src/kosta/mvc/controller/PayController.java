package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

public interface PayController {

	  /**
	    * ���� ����Ʈ�� �߰��ϱ�
	    * */
		 void insertPay(Pay pay) throws SQLException;
		 
		 
		 /**
		  * ���� ����Ʈ �����ϱ� 
		  * */
		 void payDelete(int payNo) throws SQLException;
		 
		 /**
		  * ���� ����Ʈ ��������
		  * */
		 void selectPayByUserId(String userId)throws SQLException;
}




