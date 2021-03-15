package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Wish;
import kosta.mvc.util.DbUtil;

/*
 * 더 생각해 볼 것.
 * - 위시리스트에 많이 오른 방을 인기방에 검색되도록 하는 기능
 * */
public class WishDAOImpl implements WishDAO {
	RoomsDAO roomsDAO = new RoomsDAOImpl();
	private Properties proFile = DbUtil.getProFile();
	
	@Override
	public int wishInsert(Wish wish) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("wish.insert"); 
//		wish.insert=insert into wish_list values(WISH_LIST_NO_SEQ.NEXTVAL, ?, ?, SYSDATE)
//		user_No	 room_No
		
		int result=0;
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, wish.getUserNo());
			ps.setInt(2, wish.getRoomNo());

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);	
		}

		return result;
	}

	@Override
	public int wishDelete(int wishNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("wish.delete"); 
//		wish.delete=delete from WISH_LIST where wish_No = ?
		
		int result=0;
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, wishNo);

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);	
		}

		return result;
	}

	@Override
	public List<Wish> selectWishByUserId(String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Wish> wishList = new ArrayList<>();
		Wish wish = null;
		String sql=proFile.getProperty("wish.select"); 
//		wish.select=SELECT * FROM USER_DATA JOIN WISH_LIST USING(USER_NO) JOIN ROOM_DATA USING(ROOM_NO) WHERE USER_ID=?
		
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int wishNo = rs.getInt(1);
				int userNo = rs.getInt(2);
				int roomNo = rs.getInt(3);
				String wishDate = rs.getString(4);
				
				wish = new Wish(wishNo, userNo, roomNo, wishDate);
				wishList.add(wish);
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return wishList;
	}

	@Override
	public List<Wish> selectWishList() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Wish> wishList = new ArrayList<>();
		Wish wish = null;
		String sql=proFile.getProperty("wish.selectAll"); 
//		wish.selectAll=select * from WISH_LIST
		
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int wishNo = rs.getInt(1);
				int userNo = rs.getInt(2);
				int roomNo = rs.getInt(3);
				String wishDate = rs.getString(4);
				
				wish = new Wish(wishNo, userNo, roomNo, wishDate);
				wishList.add(wish);
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return wishList;
		
	}

}
