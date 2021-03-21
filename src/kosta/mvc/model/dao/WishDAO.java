package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import kosta.mvc.model.dto.Wish;

/**
 * 관심리스트 등록/삭제/검색 기능
 * :관심있는 방을 관심리스트에 등록/삭제하고, 관심있는 방을 검색하는 용도.
 * 
 * @author Minjoo Jo
 * @version 1.0
 * */
public interface WishDAO {
	
	/**
	   * 관심있는 방을 관심리스트에 추가하기
	   * : WISH_LIST 테이블에 insert
	   * @param Wish wish
	   * @return int 
	   * @throws SQLException
	   * */
		int wishInsert(Wish wish)throws SQLException;

		/**
		   * 관심번호로 더이상 관심없는 방 관심리스트에서 삭제하기
		   * : WISH_LIST 테이블에서 delete
		   * @param int wishNo
		   * @return int 
		   * @throws SQLException
		   * */
		int wishDelete(int wishNo) throws SQLException;
		
		
		/**
		 * 해당 아이디로 관심리스트 전체 보기 
		 * @param String userId
		 * @return List<Wish>  
		 * @throws SQLException
		 * */
		List<Wish> selectWishByUserId(String userId)throws SQLException;
		
		/**
		 * 모든 회원의 관심리스트  전체 보기 --관리자용
		 * @return List<Wish>
		 * @throws SQLException
		 * */
		List<Wish> selectWishList()throws SQLException;

}
