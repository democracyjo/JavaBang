package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewDAO {

	/**
	 * ¿€º∫«— ∏Æ∫‰ ∫∏±‚
	 */
	List<Review> selectReviewByUserNo(int userNo) throws SQLException;
	
	/**
	 * ∏Æ∫‰ µÓ∑œ
	 */
	int insertReview(Review review) throws SQLException;
	
	/**
	 * ∏Æ∫‰ ºˆ¡§
	 */
	 int updateReview(Review review) throws SQLException;
	
	/**
	 * ∏Æ∫‰ ªË¡¶
	 */
	int deleteReview(int userNo) throws SQLException;
	


}
