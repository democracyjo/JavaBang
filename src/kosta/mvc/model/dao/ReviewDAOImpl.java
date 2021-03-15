package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Review;
import kosta.mvc.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DbUtil.getProFile();

	/**
	 * 방별 리뷰 보기
	 */
	@Override
	public List<Review> selectReviewByRoomNo(int roomNo) throws SQLException {
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList<Review>();
		String sql = proFile.getProperty("review.selectByRoomNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reviewNo = rs.getInt("review_no");
				int userNo = rs.getInt("user_no");
				roomNo = rs.getInt("room_no");
				int score = rs.getInt("score");
				String reviewContent = rs.getString("review_content");
				String reviewDate = rs.getString("review_date");

				Review review = new Review(reviewNo, userNo, roomNo, score, reviewContent, reviewDate);

				list.add(review);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	/**
	 * 자신의 리뷰 보기
	 */

	@Override
	public List<Review> selectReviewByUserNo(int userNo) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList<Review>();
		String sql = proFile.getProperty("review.selectByUserNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reviewNo = rs.getInt("review_no");
				userNo = rs.getInt("user_no");
				int roomNo = rs.getInt("room_no");
				int score = rs.getInt("score");
				String reviewContent = rs.getString("review_content");
				String reviewDate = rs.getString("review_date");

				Review review = new Review(reviewNo, userNo, roomNo, score, reviewContent, reviewDate);

				list.add(review);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	/**
	 * 리뷰 등록하기
	 */
	@Override
	public int insertReview(Review review) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList<Review>();
		int result = 0;
		String sql = proFile.getProperty("pay.selectUserNo");
		// String sql=proFile.getProperty("review.insert");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, review.getUserNo());
			rs = ps.executeQuery();
			while (rs.next()) {
				int userNo = rs.getInt("user_no");
				int roomNo = rs.getInt("room_no");
				Review rv = new Review(0, userNo, roomNo, 0, null, null);
				list.add(rv);
			}
		} finally {
			DbUtil.close(con, ps);
		}
		sql = proFile.getProperty("review.insert");

		if (list.contains(review)) {
			if (!selectReviewByRoomNo(review.getRoomNo()).contains(review)) {
				try {
					con = DbUtil.getConnection();
					ps = con.prepareStatement(sql);

					ps.setInt(1, review.getUserNo());
					ps.setInt(2, review.getRoomNo());
					ps.setInt(3, review.getScore());
					ps.setString(4, review.getReviewContent());

					result = ps.executeUpdate();

				} finally {
					DbUtil.close(con, ps);
				}
				return result;
			}else {
				throw new SQLException("이미 작성된 리뷰가 있습니다.");
			}
		}

		throw new SQLException(review.getRoomNo() + "방에 숙박 한 적이 없습니다.");

	}

	/**
	 * 리뷰 수정하기
	 */
	@Override
	public int updateReview(Review review) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("review.updateByNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, review.getReviewContent());
			ps.setInt(2, review.getReviewNo());

			result = ps.executeUpdate();

		} finally {
			DbUtil.close(con, ps);
		}
		return result;
	}

	/**
	 * 리뷰 삭제하기
	 */
	@Override
	public int deleteReview(int reviewNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("review.deleteByNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);

			result = ps.executeUpdate();

		} finally {
			DbUtil.close(con, ps);
		}
		return result;

	}

	/**
	 * 리뷰 평점 구하기
	 */
	@Override
	public double getAvgP(int roomNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList<Review>();
		String sql = proFile.getProperty("review.selectByRoomNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reviewNo = rs.getInt("review_no");
				int userNo = rs.getInt("user_no");
				roomNo = rs.getInt("room_no");
				int score = rs.getInt("score");
				String reviewContent = rs.getString("review_content");
				String reviewDate = rs.getString("review_date");

				Review review = new Review(reviewNo, userNo, roomNo, score, reviewContent, reviewDate);

				list.add(review);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}

		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getScore();
		}
		double avg = sum / ((double) list.size());
		return avg;
	}

}
