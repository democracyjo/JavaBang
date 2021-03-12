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
			ps= con.prepareStatement(sql);
			// ps=con.prepareStatement(JavaBang.~~)
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int roomNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				String floor = rs.getString(5); // 층수
				int aprprNmbP=rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				
				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus, prcadPrsn);
				
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
		List<Room> list = new ArrayList<Room>();
		try {
			con = DbUtil.getConnection();
			 ps= con.prepareStatement("room.selectAll");
			// ps=con.prepareStatement(JavaBang.~~)
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int roomvNo = rs.getInt(1); // 방번호
				int roomType = rs.getInt(2); // 방 종류
				double roomSize = rs.getDouble(3); // 방크기
				int price = rs.getInt(4); // 방가격
				String floor = rs.getString(5); // 층수
				int aprprNmbP=rs.getInt(6);
				int numberBeds = rs.getInt(7);
				boolean breakfastStatus = rs.getString(8).toUpperCase().equals("TRUE");
				int prcadPrsn = rs.getInt(9);
				
				Room rm = new Room(roomNo, roomType, roomSize, price, floor, aprprNmbP, numberBeds, breakfastStatus, prcadPrsn);
				
				list.add(rm);
				
				// 추가인원당 가격
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return null;
	}

	@Override
	public List<Room> searchByRoomType(List<String> roomType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> searchByRoomSize(int minSize, int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> searchByRoomPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
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
