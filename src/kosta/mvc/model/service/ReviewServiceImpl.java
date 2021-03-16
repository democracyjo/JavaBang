package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.PayDAO;
import kosta.mvc.model.dao.PayDAOImpl;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.Review;

public class ReviewServiceImpl implements ReviewService{

	private ReviewDAO reviewDAO = new ReviewDAOImpl();
		

	@Override
	public List<Review> selectReviewByRoomNo(int roomNo) throws SQLException {
		List<Review> reviewList = reviewDAO.selectReviewByRoomNo(roomNo);
		if(reviewList == null || reviewList.size()==0) {
			throw new SQLException(roomNo + "에 해당하는 리뷰가 없습니다.");
		}
		return reviewList;
	}

	@Override
	public List<Review> selectReviewByUserNo(int userNo) throws SQLException {
		List<Review> reviewList = reviewDAO.selectReviewByUserNo(userNo);
		if(reviewList == null || reviewList.size()==0) {
			throw new SQLException("검색된 리뷰가 없습니다.");
		}
		return reviewList;
	}
	
	@Override
	public void insertReview(Review review) throws SQLException {
		int rev = reviewDAO.insertReview(review);
		if(rev==0) {
			throw new SQLException("리뷰 등록 실패하였습니다.");
		}
	}

	@Override
	public void updateReview(Review review) throws SQLException {
		int rev = reviewDAO.updateReview(review);
		if(rev==0)throw new SQLException("리뷰 수정 실패하였습니다.");
	}

	@Override
	public void deleteReview(int reviewNo) throws SQLException {
		int rev = reviewDAO.deleteReview(reviewNo);
		if(rev ==0) {
			throw new SQLException(reviewNo + "리뷰 삭제 실패하였습니다.");
		}
		
	}
/*
	@Override
	public double getAvgP(int roomNo) throws SQLException {
		return reviewDAO.getAvgP(roomNo);
	}
	*/
	
}