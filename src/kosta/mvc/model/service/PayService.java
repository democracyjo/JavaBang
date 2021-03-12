package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

public interface PayService {
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
		 List<Pay> selectPayByUserId(String userId)throws SQLException;
}
