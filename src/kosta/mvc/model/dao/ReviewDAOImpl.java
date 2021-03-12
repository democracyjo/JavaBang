package kosta.mvc.model.dao;

import java.awt.image.DataBufferUShort;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Review;
import kosta.mvc.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO{
	private Properties proFile = DbUtil.getProFile();
	
	/**
	 * 자신의 리뷰 보기
	 */

	@Override
	public List<Review> selectReviewByUserNo(int userNo) throws SQLException {
		// 로드 연결 실행 닫기
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Review> list = new ArrayList<Review>();
		String sql=proFile.getProperty("review.selectByUserNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				int reviewNo = rs.getInt("review_no");
				userNo = rs.getInt("user_no");
				int roomNo = rs.getInt("room_no");
				int score = rs.getInt("score");
				String reviewContent = rs.getString("review_content");
				String reviewDate = rs.getString("review_date");
			
				Review review = new Review(reviewNo, userNo, roomNo, score, reviewContent, reviewDate);
				
				list.add(review);
			}
		}finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	/**
	 * 리뷰 등록하기
	 */
	@Override
	public int insertReview(Review review) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=proFile.getProperty("review.insert");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, review.getUserNo());
			ps.setInt(2, review.getRoomNo());
			ps.setInt(3, review.getScore());
			ps.setString(4, review.getReviewContent());
			ps.setString(5, review.getReviewDate());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);
		}
		return result;
		
	}

	/**
	 * 리뷰 수정하기
	 */
	@Override
	public int updateReview(Review review) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=proFile.getProperty("review.updateByNo");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, review.getReviewContent());
			ps.setInt(2, review.getReviewNo());
		
			result=ps.executeUpdate();
		}finally {
			DbUtil.close(con, ps);
		}
		return result;
	}		
		
	

	/**
	 * 리뷰 삭제하기
	 */
	@Override
	public int deleteReview(int userNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=proFile.getProperty("board.deleteByNo");
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, userNo);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);
		}
		return result;
		
	}
	
}
