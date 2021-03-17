package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewService {

	/**
	 * πÊ∫∞ ∏Æ∫‰ ∫∏±‚
	 * @param roomNo
	 * @return List<Review>
	 * @throws SQLException
	 */
	List<Review> selectReviewByRoomNo(int roomNo) throws SQLException;
	/**
	 * ¿€º∫«— ∏Æ∫‰ ∫∏±‚
	 * @param userNo
	 * @return List<Review>
	 * @throws SQLException
	 */
	List<Review> selectReviewByUserNo(int userNo) throws SQLException;
	
	/**
	 * ∏Æ∫‰ µÓ∑œ
	 * @param review
	 * @throws SQLException
	 */
	void insertReview(Review review) throws SQLException;
	
	/**
	 * ∏Æ∫‰ ºˆ¡§
	 * @param review
	 * @throws SQLException
	 */
	void updateReview(Review review) throws SQLException;	
	
	/**
	 * ∏Æ∫‰ ªË¡¶
	 * @param reviewNo
	 * @throws SQLException
	 */
	void deleteReview(int reviewNo) throws SQLException;
	
//	double getAvgP(int roomNo) throws SQLException;
	
	


}
