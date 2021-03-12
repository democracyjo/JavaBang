package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Wish;
import kosta.mvc.model.service.WishService;
import kosta.mvc.model.service.WishServiceImpl;

public interface WishController {
	
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
	void selectWishByUserId(String userId)throws SQLException;
	
}




