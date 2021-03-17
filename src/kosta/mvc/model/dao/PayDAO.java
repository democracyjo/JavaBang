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
	   * @throws SQLException
	   * */
		int payInsert(Pay pay)throws SQLException;
		
		/**
		 * ��������Ʈ �����ϱ� 
		 * @param int payNo
		 * @return int
		 * @throws SQLException
		 * */
		int payDelete(int payNo) throws SQLException;
		
		/**
		 * ��������Ʈ ��ü ���� (���̵��)
		 * @param String userId
		 * @return List<Pay> 
		 * @throws SQLException
		 * */
		List<Pay> selectPayByUserId(String userId)throws SQLException;
		
		/**
		 * ��������Ʈ ��ü--�����ڿ�
		 * @return List<Pay>
		 * @throws SQLException
		 * */
		List<Pay> selectPayList() throws SQLException;
		
		/**
		 * ��������Ʈ ���� (������ȣ��)
		 * @param int userNo
		 * @return List<Pay>
		 * @throws SQLException
		 */
		List<Pay> selectPayByUserNo(int userNo)throws SQLException;
}
