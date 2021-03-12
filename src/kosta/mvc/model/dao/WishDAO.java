package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Wish;

public interface WishDAO {
	
	/**
	   * 관심리스트에 추가하기
	   * : WISH_LIST 테이블에 insert
	   * @param Wish wish
	   * @return int 
	   * */
		int wishInsert(Wish wish)throws SQLException;
		
		/**
		   * 관심리스트 삭제하기
		   * : WISH_LIST 테이블에서 delete
		   * @param int wishNo
		   * @return int 
		   * */
		int wishDelete(int wishNo) throws SQLException;
		
		
		/**
		 * 관심리스트 전체 보기 
		 * @param String userId
		 * @return List<Wish>  
		 * */
		List<Wish> selectWishByUserId(String userId)throws SQLException;

}
