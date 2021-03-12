package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

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
		  * ���ɸ���Ʈ ��������
		  * */
		 List<Wish> selectWishByUserId(String userId)throws SQLException;
}
