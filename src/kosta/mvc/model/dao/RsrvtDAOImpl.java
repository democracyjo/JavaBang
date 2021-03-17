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
	public int reservationInsert(Reservation rsrvt, Room room) throws SQLException, ParseException {
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
			ps.setInt(5, getTotalAmount(rsrvt, room));//�ѱݾ� ������ִ� �޼��� ȣ��.
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
				
				int reserListNo = rs.getInt("reser_no");
				String date = rs.getString("reser_date");
				int userNo = rs.getInt("user_no");
				String checkinDate = rs.getString("checkin_date");
				String checkoutDate = rs.getString("checkout_date");
				int totalPplNum = rs.getInt("total_people_num");
				int totalPrice = rs.getInt("total_price");
				int roomNo = rs.getInt("room_no");
				
				
				rsrvt = new Reservation(reserListNo, date, userNo, checkinDate, checkoutDate, totalPplNum, totalPrice, roomNo);
				reserList.add(rsrvt);
			
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return reserList;
	}
	
	
	/**
	 * �ѱݾװ��
	 * */
	public int getTotalAmount(Reservation reser, Room room) throws SQLException, ParseException {
		
		int roomNo = reser.getRoomNo();//�����ѹ�
		int roomPrice = room.getPrice();//�� �Ϲڴ� ����
		int ppl = room.getAprprNmbP();//���� �����ο�
		int addPrice =  room.getPrcadPrsn(); //�߰��ο��� ����
		
	    int totalPrice =0;
	    if(roomNo==room.getRoomNo()) {
	    	Room pickedroom = roomsDAO.searchByRoomNo(roomNo);
	    	
	    	if(pickedroom==null) throw new SQLException("�ش� ��ȣ�� ���� �������� �ʽ��ϴ�. �ٽ� �Է��� �ּ���");
	    	    	
	    	totalPrice = calDate(reser)*roomPrice;
	    	
	    	if(reser.getTotalpeopleNum() > ppl) {
	    		totalPrice = calDate(reser)*(roomPrice +((reser.getTotalpeopleNum()-ppl)*addPrice));
	    	}
	    			
	    }
		return totalPrice;
	}
	
	/**
	 * ��¥���̰��
	 * */
	public static int calDate(Reservation reser) throws ParseException{
		String date1 = reser.getCheckoutDate();//üũ�ƿ���¥
		String date2 = reser.getCheckinDate();//üũ�γ�¥
		int days=0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //formatting�� pattern �����ؼ� ����� ��!(M:��/m:��)
		Date FirstDate = format.parse(date1);
		Date SecondDate = format.parse(date2);

		long calDate = FirstDate.getTime() - SecondDate.getTime(); 

		long calDateDays = calDate / ( 24*60*60*1000); 

		days = (int)(Math.abs(calDateDays));

		return days;
	} 
	
	/**
	 * ���೯¥ �ߺ�üũ 
	 * @throws SQLException 
	 * */
	public static boolean isDuplicatedReser(List<Reservation> reserList, Reservation reser) throws SQLException, ParseException{
		if(reserList==null) return false;
		
		for(Reservation reserv :reserList) {
			if(reser.getRoomNo()==reserv.getRoomNo()) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date day1=null;
				Date day2=null;
				Date day3=null;
				Date day4=null;
			
					day1 =format.parse(reser.getCheckinDate()) ;
					day2 =format.parse(reserv.getCheckoutDate());
					day3 =format.parse(reser.getCheckoutDate());
					day4 =format.parse(reserv.getCheckinDate());
					
					int compare12 = day1.compareTo(day2);
					int compare34 = day3.compareTo(day4);
				
					if(compare12 < 0  && compare34 > 0) {
						return true;
					}
					
			}else {
				return false;
			}
		}
		return false;
	}

	/**
	 * ȸ�� ��ü ���ฮ��Ʈ
	 * reservation.selectAll=select * from RESERVATION_LIST
	 * */
	@Override
	public List<Reservation> selectRsrvtAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Reservation> reserList = new ArrayList<>();
		Reservation rsrvt = null;
		String sql=proFile.getProperty("reservation.selectAll"); 
		
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int reserListNo = rs.getInt("reser_no");
				String date = rs.getString("reser_date");
				int userNo = rs.getInt("user_no");
				String checkinDate = rs.getString("checkin_date");
				String checkoutDate = rs.getString("checkout_date");
				int totalPplNum = rs.getInt("total_people_num");
				int totalPrice = rs.getInt("total_price");
				int roomNo = rs.getInt("room_no");
				
				
				rsrvt = new Reservation(reserListNo, date, userNo, checkinDate, checkoutDate, totalPplNum, totalPrice, roomNo);
				reserList.add(rsrvt);
			
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return reserList;
	}

	@Override
	public List<Reservation> selectRsrvtByRoomNo(int roomNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Reservation> reserList = new ArrayList<>();
		Reservation rsrvt = null;
		String sql=proFile.getProperty("reservation.selectByRoomNo"); 

		
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomNo );
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int reserListNo = rs.getInt("reser_no");
				String date = rs.getString("reser_date");
				int userNo = rs.getInt("user_no");
				String checkinDate = rs.getString("checkin_date");
				String checkoutDate = rs.getString("checkout_date");
				int totalPplNum = rs.getInt("total_people_num");
				int totalPrice = rs.getInt("total_price");
//				int roomNo = rs.getInt("room_no");
				
				rsrvt = new Reservation(reserListNo, date, userNo, checkinDate, checkoutDate, totalPplNum, totalPrice, roomNo);
				reserList.add(rsrvt);
			
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return reserList;
	}

}//end of class
