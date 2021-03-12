package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

public interface PayDAO {
	
	/**
	   * ��������Ʈ�� �߰��ϱ�
	   * 1) PAY_LIST ���̺� insert
	   * 2) �ش� �� ���డ���� ������Ʈ.
	   * @param Pay pay
	   * @return int 
	   * */
		int payInsert(Pay pay)throws SQLException;
		
		
		
		/**
		 * ��������Ʈ ��ü ���� 
		 * @param String userId
		 * @return List<Pay> 
		 * */
		List<Pay> selectPayByUserId(String userId)throws SQLException;

}
