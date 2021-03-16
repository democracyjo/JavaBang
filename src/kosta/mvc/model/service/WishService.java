package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.User;
import kosta.mvc.model.dto.Wish;

public interface WishService {
	   /**
	    * ���� ����Ʈ�� �߰��ϱ�
	    * */
		 void insertWish(Wish wish) throws SQLException;
		 
		 
		 /**
		  * ���ɸ���Ʈ �����ϱ� 
		  * */
		 void wishDelete(int wishNo) throws SQLException;
		 
		 
		 /**
		  * ���ɸ���Ʈ ��������(�ش���̵�)
		  * */
		 List<Wish> selectWishByUserId(String userId)throws SQLException;
		 
		 /**
		  * ���ɸ���Ʈ ��ü ����
		  * */
		 List<Wish> selectWishList() throws SQLException;
		 
		 /**
		  * ���ɵ�ϵ� ���ȣ üũ
		  * */
		 public boolean hasRoomNo(User user, int roomNo) throws SQLException;
		 
}
