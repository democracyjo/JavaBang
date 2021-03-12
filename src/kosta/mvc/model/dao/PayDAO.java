package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

public interface PayDAO {
	
	/**
	   * 결제리스트에 추가하기
	   * 1) PAY_LIST 테이블에 insert
	   * 2) 해당 방 예약가능일 업데이트.
	   * @param Pay pay
	   * @return int 
	   * */
		int payInsert(Pay pay)throws SQLException;
		
		
		
		/**
		 * 결제리스트 전체 보기 
		 * @param String userId
		 * @return List<Pay> 
		 * */
		List<Pay> selectPayByUserId(String userId)throws SQLException;

}
