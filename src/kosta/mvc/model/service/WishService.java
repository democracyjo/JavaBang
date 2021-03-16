package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.User;
import kosta.mvc.model.dto.Wish;

public interface WishService {
	   /**
	    * 관심 리스트에 추가하기
	    * */
		 void insertWish(Wish wish) throws SQLException;
		 
		 
		 /**
		  * 관심리스트 삭제하기 
		  * */
		 void wishDelete(int wishNo) throws SQLException;
		 
		 
		 /**
		  * 관심리스트 내역보기(해당아이디)
		  * */
		 List<Wish> selectWishByUserId(String userId)throws SQLException;
		 
		 /**
		  * 관심리스트 전체 보기
		  * */
		 List<Wish> selectWishList() throws SQLException;
		 
		 /**
		  * 관심등록된 방번호 체크
		  * */
		 public boolean hasRoomNo(User user, int roomNo) throws SQLException;
		 
}
