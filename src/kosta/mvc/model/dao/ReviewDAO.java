package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewDAO {

	
	/**
	 * 방별 리뷰 보기
	 * @param roomNo
	 * @return List<Review>
	 * @throws SQLException
	 */
	List<Review> selectReviewByRoomNo(int roomNo) throws SQLException;

	
	/**
	 * 작성한 리뷰 보기
	 * @param userNo
	 * @return List<Review>
	 * @throws SQLException
	 */
	List<Review> selectReviewByUserNo(int userNo) throws SQLException;
	
	/**
	 * 리뷰 등록
	 * @param review
	 * @return
	 * @throws SQLException
	 */
	int insertReview(Review review) throws SQLException;
	
	
	
	/**
	 * 리뷰 삭제
	 * @param reviewNo
	 * @return
	 * @throws SQLException
	 */
	int deleteReview(int reviewNo) throws SQLException;


	/**
	 * 리뷰 수정하기
	 * @param review
	 * @return
	 * @throws SQLException
	 */
	int updateReview(Review review) throws SQLException;
	
	/**
	 * 리뷰 평점구하기
	 * @param roomNo
	 * @return
	 * @throws SQLException
	 */
	double getAvgP(int roomNo) throws SQLException;

}
