package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Review;
import kosta.mvc.model.dto.Room;
import kosta.mvc.util.DbUtil;

public class RoomsDAOImpl implements RoomsDAO {
	private static Properties proFile = DbUtil.getProFile();

	/**
	 * 모든 방 출력
	 */
	public List<Room> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.selectAll");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ps=con.prepareStatement(JavaBang.~~)
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn, avgScore);
			
				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public Room searchByRoomNo(int roomNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room rm = null;
		String sql = proFile.getProperty("room.searchByRoomNo");
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ps=con.prepareStatement(JavaBang.~~)
			ps.setInt(1, roomNo);
			rs = ps.executeQuery();

			if (rs.next()) {

				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);

				rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn, avgScore);
				
				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return rm;
	}

	@Override
	public List<Room> searchByRoomType(List<String> roomType) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.searchByRoomType");
	
		try {
			for (int i = 0; i < roomType.size(); i++) {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, roomType.get(i));
				rs = ps.executeQuery();

				while (rs.next()) {
					int roomNo = rs.getInt("room_no"); // 방번호
					int roomTypeNo = rs.getInt("room_type_no");
					double roomSize = rs.getDouble(3); // 방크기
					int price = rs.getInt(4); // 방가격
					int floor = rs.getInt(5); // 층수
					int aprprNmbP = rs.getInt(6);
					int numberBeds = rs.getInt(7);
					boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
					int prcadPrsn = rs.getInt(9);
					double avgScore=rs.getDouble(10);

					Room rm = new Room(roomNo, roomTypeNo, roomSize, price, floor, aprprNmbP, numberBeds,
							breakfastStatus, prcadPrsn,avgScore);
				
					list.add(rm);

					// 추가인원당 가격
				}
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByRoomSize(double minSize, double maxSize) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.searchByRoomSize");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setDouble(1, minSize);
			ps.setDouble(2, maxSize);
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn,avgScore);
				
				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.searchByRoomPrice");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn,avgScore);
				
				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByFloor(int minFloor,int maxFloor) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.searchByFloor");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, minFloor);
			ps.setInt(2, maxFloor);
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor=rs.getInt(5);// 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);
				
				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn,avgScore);
			
				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByNumberPeople(int minNum, int maxNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.searchByNumberPeople");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, minNum);
			ps.setInt(2, maxNum);
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn,avgScore);
				
				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByNumberBeds(int minNum, int maxNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.searchByNumberBeds");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, minNum);
			ps.setInt(2, maxNum);
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);
				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn,avgScore);
				
				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByBreakfastStat(boolean bfStat) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.searchByBreakfastStat");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (bfStat) {
				ps.setString(1, "true");
			} else {
				ps.setString(1, "false");
			}
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);
				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn, avgScore);
								list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	public static String getRoomType(int roomTypeNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = proFile.getProperty("room.getRoomType");
		String roomType = "";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomTypeNo);
			rs = ps.executeQuery();
			if (rs.next()) {

				roomType = rs.getString("room_Type");

			}
		} finally

		{
			DbUtil.close(con, ps, rs);
		}
		return roomType;
	}
	
	@Override
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws SQLException {
		
		RsrvtDAO rsDAO = new RsrvtDAOImpl();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> list = new ArrayList<Room>();
		String sql = proFile.getProperty("room.selectAll");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				int floor = rs.getInt(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				double avgScore=rs.getDouble(10);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn, avgScore);
				
				Reservation rv = new Reservation(0, null, 0, checkinDate, checkoutDate, 0, 0, roomNo);
				
				if(RsrvtDAOImpl.isDuplicatedReser(rsDAO.selectRsrvtByRoomNo(roomNo), rv)){
					continue;
				}
				
				list.add(rm);
			}
			// 추가인원당 가격
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public void upDateAvgScroe(int roomNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql = proFile.getProperty("room.updateAvgScore");
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, roomNo);
			ps.setInt(2, roomNo);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(con, ps);
		}
	}

	@Override
	public void updateAvgByRevNo(int reviewNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		String sql = proFile.getProperty("room.updateAvgByRevNo");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, reviewNo);
			ps.setInt(2, reviewNo);
			ps.setInt(3, reviewNo);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(con, ps);
		}
	}
	
	
	

}
