package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsDAO {

	public List<Room> selectAll() throws SQLException;

	public Room searchByRoomNo(int roomNo)throws SQLException;

	public List<Room> searchByRoomType(List<String> roomType)throws SQLException;

	public List<Room> searchByRoomSize(double minSize, double maxSize)throws SQLException;

	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws SQLException;

	public List<Room> searchByFloor(int minFloor, int maxFloor)throws SQLException;

	public List<Room> searchByNumberPeople(int minNum, int maxNum)throws SQLException;

	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws SQLException;

	public List<Room> searchByBreakfastStat(boolean bfStat) throws SQLException;
	
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws SQLException;

}
