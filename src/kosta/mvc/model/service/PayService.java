package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

public interface PayService {
	   /**
	    * ���� ����Ʈ�� �߰��ϱ�
	    * @param Pay pay
	    * @throws SQLException
	    * */
		void insertPay(Pay pay) throws SQLException;
		 
		 
		 /**
		  * ���� ����Ʈ �����ϱ� 
		  * @param int payNo
		  * @throws SQLException
		  * */
		 void payDelete(int payNo) throws SQLException;
		 
		 /**
		  * ���� ����Ʈ ��������
		  * @param String userId
		  * @return List<Pay>
		  * @throws SQLException
		  * */
		 List<Pay> selectPayByUserId(String userId)throws SQLException;
}
