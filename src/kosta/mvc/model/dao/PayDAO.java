package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

/**
 * 결제리스트에 결제 정보 등록/검색/삭제 기능
 * 예약된 방을 결제하고, 결제된 정보를 검색/삭제 하는 용도.
 * 
 * @author Minjoo Jo
 * @version 1.0
 * */
public interface PayDAO {
	
	/**
	   * 결제리스트에 추가하기
	   * 1) PAY_LIST 테이블에 insert
	   * 2) 해당 방 예약가능일 업데이트.
	   * @param Pay pay
	   * @return int 
	   * @throws SQLException
	   * */
		int payInsert(Pay pay)throws SQLException;
		
		/**
		 * 결제번호로 결제리스트 삭제하기 
		 * @param int payNo 결제번호
		 * @return int
		 * @throws SQLException
		 * */
		int payDelete(int payNo) throws SQLException;
		
		/**
		 * 해당 아이디로 결제리스트 전체 보기 
		 * @param String userId
		 * @return List<Pay> : 결제정보 
		 * @throws SQLException
		 * */
		List<Pay> selectPayByUserId(String userId)throws SQLException;
		
		/**
		 * 모든 회원의 결제리스트 전체보기 --관리자용
		 * @return List<Pay>
		 * @throws SQLException
		 * */
		List<Pay> selectPayList() throws SQLException;
		
		/**
		 * 유저번호로 결제리스트 보기 
		 * @param int userNo
		 * @return List<Pay>
		 * @throws SQLException
		 */
		List<Pay> selectPayByUserNo(int userNo)throws SQLException;
}
