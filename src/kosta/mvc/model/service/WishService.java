package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.User;
import kosta.mvc.model.dto.Wish;

public interface WishService {
	   /**
	    * ���� ����Ʈ�� �߰��ϱ�
	    * @param Wish wish
	    * @throws SQLException
	    * */
		 void insertWish(Wish wish) throws SQLException;
		 
		 
		 /**
		  * ���ɸ���Ʈ �����ϱ� 
		  * @param int wishNo
		  * @throws SQLException
		  * */
		 void wishDelete(int wishNo) throws SQLException;
		 
		 
		 /**
		  * ���ɸ���Ʈ ��������(�ش���̵�)
		  * @param String userId
		  * @return List<Wish>
		  * @throws SQLException
		  * */
		 List<Wish> selectWishByUserId(String userId)throws SQLException;
		 
		 /**
		  * ���ɸ���Ʈ ��ü ����
		  * @return List<Wish>
		  * @throws SQLException
		  * */
		 List<Wish> selectWishList() throws SQLException;
		 
		 /**
		  * ���ɵ�ϵ� ���ȣ üũ
		  * @param User user, int roomNo
		  * @return boolean
		  * @throws SQLException
		  * */
		 public boolean hasRoomNo(User user, int roomNo) throws SQLException;
		 
}
