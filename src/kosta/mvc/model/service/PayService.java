package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;

public interface PayService {
	   /**
	    * 결제 리스트에 추가하기
	    * @param Pay pay
	    * @throws SQLException
	    * */
		void insertPay(Pay pay) throws SQLException;
		 
		 
		 /**
		  * 결제 리스트 삭제하기 
		  * @param int payNo
		  * @throws SQLException
		  * */
		 void payDelete(int payNo) throws SQLException;
		 
		 /**
		  * 결제 리스트 내역보기
		  * @param String userId
		  * @return List<Pay>
		  * @throws SQLException
		  * */
		 List<Pay> selectPayByUserId(String userId)throws SQLException;
}
