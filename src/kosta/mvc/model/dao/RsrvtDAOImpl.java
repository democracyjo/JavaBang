package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;
import kosta.mvc.util.DbUtil;

public class RsrvtDAOImpl implements RsrvtDAO {
	private Properties proFile = DbUtil.getProFile();
	RoomsDAO roomsDAO = new RoomsDAOImpl();
	UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public int reservationInsert(Reservation rsrvt, Room room) throws SQLException {
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
			ps.setInt(5, getTotalAmount(rsrvt, room));//
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
	
	
	/**
	 * 총금액계산
	 * */
	public int getTotalAmount(Reservation reser, Room room) throws SQLException {
		
		int roomNo = reser.getRoomNo();//예약방넘버
		int roomPrice = room.getPrice();//방 일박당 가격
		int ppl = room.getAprprNmbP();//방의 적정인원
		int addPrice =  room.getPrcadPrsn(); //추가인원당 가격
		
	    int totalPrice =0;
	    if(roomNo==room.getRoomNo()) {
	    	Room pickedroom = roomsDAO.searchByRoomNo(roomNo);
	    	
	    	if(pickedroom==null) throw new SQLException("해당 번호의 방은 존재하지 않습니다. 다시 입력해 주세요");
	    	    	
	    	totalPrice += calDate(reser)*roomPrice;
	    	
	    	if(reser.getTotalpeopleNum() > ppl) {
	    		totalPrice += calDate(reser)*(roomPrice +((reser.getTotalpeopleNum()-ppl)*addPrice));
	    	}
	    			
	    }
		return totalPrice;
	}
	
	/**
	 * 날짜차이계산
	 * */
	public static int calDate(Reservation reser){
		String date1 = reser.getCheckoutDate();//체크아웃날짜
		String date2 = reser.getCheckinDate();//체크인날짜
		int days=0;
		try{ 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date FirstDate = format.parse(date1);
			Date SecondDate = format.parse(date2);

			long calDate = FirstDate.getTime() - SecondDate.getTime(); 

			long calDateDays = calDate / ( 24*60*60*1000); 

			days = (int)(Math.abs(calDateDays));

		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return days;
	} 

}//end of class
