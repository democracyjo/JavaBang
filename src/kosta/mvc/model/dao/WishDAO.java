package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import kosta.mvc.model.dto.Wish;

/**
 * ���ɸ���Ʈ ���/����/�˻� ���
 * :�����ִ� ���� ���ɸ���Ʈ�� ���/�����ϰ�, �����ִ� ���� �˻��ϴ� �뵵.
 * 
 * @author Minjoo Jo
 * @version 1.0
 * */
public interface WishDAO {
	
	/**
	   * �����ִ� ���� ���ɸ���Ʈ�� �߰��ϱ�
	   * : WISH_LIST ���̺� insert
	   * @param Wish wish
	   * @return int 
	   * @throws SQLException
	   * */
		int wishInsert(Wish wish)throws SQLException;

		/**
		   * ���ɹ�ȣ�� ���̻� ���ɾ��� �� ���ɸ���Ʈ���� �����ϱ�
		   * : WISH_LIST ���̺��� delete
		   * @param int wishNo
		   * @return int 
		   * @throws SQLException
		   * */
		int wishDelete(int wishNo) throws SQLException;
		
		
		/**
		 * �ش� ���̵�� ���ɸ���Ʈ ��ü ���� 
		 * @param String userId
		 * @return List<Wish>  
		 * @throws SQLException
		 * */
		List<Wish> selectWishByUserId(String userId)throws SQLException;
		
		/**
		 * ��� ȸ���� ���ɸ���Ʈ  ��ü ���� --�����ڿ�
		 * @return List<Wish>
		 * @throws SQLException
		 * */
		List<Wish> selectWishList()throws SQLException;

}
