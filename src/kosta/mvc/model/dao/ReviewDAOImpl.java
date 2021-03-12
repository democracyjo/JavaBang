package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public class ReviewDAOImpl implements ReviewDAO{

	
	/**
	 * 자신의 리뷰 보기
	 */

	@Override
	public List<Review> selectReviewByUserNo(int userNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 리뷰 등록하기
	 */
	@Override
	public int insertReview(Review review) throws SQLException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	/**
	 * 리뷰 수정하기
	 */
	@Override
	public int updateReview(Review review) throws SQLException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	/**
	 * 리뷰 삭제하기
	 */
	@Override
	public int deleteReview(int userNo) throws SQLException {
		return userNo;
		// TODO Auto-generated method stub
		
	}
	
}
