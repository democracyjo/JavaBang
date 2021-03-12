package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Room;

import kosta.mvc.util.DbUtil;

public class RoomsDAOImpl implements RoomsDAO {
	private Properties proFile = DbUtil.getProFile();

	/**
	 * 모든 방 출력
	 */
	public List<Room> selectAll() throws Exception {
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
				String floor = rs.getString(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn);

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
				String floor = rs.getString(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);

				rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn);

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
					int roomNo = rs.getInt(1); // 방번호
					int roomTypeNo=rs.getInt(2);
					double roomSize = rs.getDouble(3); // 방크기
					int price = rs.getInt(4); // 방가격
					String floor = rs.getString(5); // 층수
					int aprprNmbP = rs.getInt(6);
					int numberBeds = rs.getInt(7);
					boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
					int prcadPrsn = rs.getInt(9);

					Room rm = new Room(roomNo, roomTypeNo, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
							prcadPrsn);

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
	public List<Room> searchByRoomSize(double minSize, double maxSize) throws SQLException{
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
				String floor = rs.getString(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn);

				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice) throws SQLException{
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
				String floor = rs.getString(5); // 층수
				int aprprNmbP = rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);

				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus,
						prcadPrsn);

				list.add(rm);

				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Room> searchByFloor(int floor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> searchByNumberPeople(int numberPeople) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> searchByNumberBeds(int minNum, int maxNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> searchByBedSize(List<String> BedSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
