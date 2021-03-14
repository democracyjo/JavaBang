package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.util.DbUtil;

public class RsrvtDAOImpl implements RsrvtDAO {
	private Properties proFile = DbUtil.getProFile();
	
	@Override
	public int reservationInsert(Reservation rsrvt) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("reservation.insert"); 
//		reservation.insert=insert into RESERVATION_LIST values(RESERVATION_LIST_NO_SEQ.NEXTVAL, SYSDATE, ?, ?, ?, ?, ?, ? )
//		user_No	NUMBER(3) NOT NULL,
//		checkin_Date	DATE NOT NULL,
//		checkout_Date	DATE NOT NULL,
//		total_people_Num	 NUMBER(2) NOT NULL,
//		total_Price	NUMBER NOT NULL,
//		room_No	NUMBER(3) NOT NULL,
	
		int result=0;
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, rsrvt.getUserNo());
			ps.setString(2, rsrvt.getCheckinDate());
			ps.setString(3, rsrvt.getCheckoutDate());
			ps.setInt(4, rsrvt.getTotalpeopleNum());
			ps.setInt(5, rsrvt.getTotalPrice());
			ps.setInt(6, rsrvt.getRoomNo());
			

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);	
		}

		return result;
	}

	@Override
	public int reservationDelete(int reserNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("reservation.delete"); 
//		reservation.delete=delete from RESERVATION_LIST where reser_No = ?
		
		int result=0;
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reserNo);

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);	
		}

		return result;
	}

	@Override
	public List<Reservation> selectRsrvtByUserId(String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Reservation> reserList = new ArrayList<>();
		Reservation rsrvt = null;
		String sql=proFile.getProperty("reservation.select"); 
//		reservation.select=select * from RESERVATION_LIST where user_Id=?
		
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int reserListNo = rs.getInt(1);
				String date = rs.getString(2);
				int userNo = rs.getInt(3);
				String checkinDate = rs.getString(4);
				String checkoutDate = rs.getString(5);
				int totalPplNum = rs.getInt(6);
				int totalPrice = rs.getInt(7);
				int roomNo = rs.getInt(8);
				
				
				rsrvt = new Reservation(reserListNo, date, userNo, checkinDate, checkoutDate, totalPplNum, totalPrice, roomNo);
				reserList.add(rsrvt);
			
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return reserList;
	}

}
