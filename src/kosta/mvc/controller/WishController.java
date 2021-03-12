package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Wish;
import kosta.mvc.model.service.WishService;
import kosta.mvc.model.service.WishServiceImpl;

public interface WishController {
	
	   /**
	    * 관심 리스트에 추가하기
	    * */
	void insertWish(Wish wish) throws SQLException;
		 
		 
		 /**
		  * 관심리스트 삭제하기 
		  * */
	void wishDelete(int wishNo) throws SQLException;
		 
		 
		 /**
		  * 관심리스트 내역보기
		  * */
	void selectWishByUserId(String userId)throws SQLException;
	
}




