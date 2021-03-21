package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

/**
 * ��������Ʈ�� ���� ���� ���/�˻�/���� ���
 * ����� ���� �����ϰ�, ������ ������ �˻�/���� �ϴ� �뵵.
 * 
 * @author Minjoo Jo
 * @version 1.0
 * */
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
		 * ������ȣ�� ��������Ʈ �����ϱ� 
		 * @param int payNo ������ȣ
		 * @return int
		 * @throws SQLException
		 * */
		int payDelete(int payNo) throws SQLException;
		
		/**
		 * �ش� ���̵�� ��������Ʈ ��ü ���� 
		 * @param String userId
		 * @return List<Pay> : �������� 
		 * @throws SQLException
		 * */
		List<Pay> selectPayByUserId(String userId)throws SQLException;
		
		/**
		 * ��� ȸ���� ��������Ʈ ��ü���� --�����ڿ�
		 * @return List<Pay>
		 * @throws SQLException
		 * */
		List<Pay> selectPayList() throws SQLException;
		
		/**
		 * ������ȣ�� ��������Ʈ ���� 
		 * @param int userNo
		 * @return List<Pay>
		 * @throws SQLException
		 */
		List<Pay> selectPayByUserNo(int userNo)throws SQLException;
}
