package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewService {

	/**
	 * πÊ∫∞ ∏Æ∫‰ ∫∏±‚
	 */
	List<Review> selectReviewByRoomNo(int roomNo) throws SQLException;
	/**
	 * ¿€º∫«— ∏Æ∫‰ ∫∏±‚
	 */
	List<Review> selectReviewByUserNo(int userNo) throws SQLException;
	
	/**
	 * ∏Æ∫‰ µÓ∑œ
	 */
	void insertReview(Review review) throws SQLException;
	
	/**
	 * ∏Æ∫‰ ºˆ¡§
	 */
	void updateReview(Review review) throws SQLException;	
	
	/**
	 * ∏Æ∫‰ ªË¡¶
	 */
	void deleteReview(int reviewNo) throws SQLException;
	
	double getAvgP(int roomNo) throws SQLException;
	
	


}
