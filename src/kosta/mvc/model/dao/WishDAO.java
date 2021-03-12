package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Wish;

public interface WishDAO {
	
	/**
	   * ���ɸ���Ʈ�� �߰��ϱ�
	   * : WISH_LIST ���̺� insert
	   * @param Wish wish
	   * @return int 
	   * */
		int wishInsert(Wish wish)throws SQLException;
		
		/**
		   * ���ɸ���Ʈ �����ϱ�
		   * : WISH_LIST ���̺��� delete
		   * @param int wishNo
		   * @return int 
		   * */
		int wishDelete(int wishNo) throws SQLException;
		
		
		/**
		 * ���ɸ���Ʈ ��ü ���� 
		 * @param String userId
		 * @return List<Wish>  
		 * */
		List<Wish> selectWishByUserId(String userId)throws SQLException;

}
