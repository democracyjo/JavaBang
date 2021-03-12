package kosta.mvc.model.dao;

import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsDAO {

	public List<Room> selectAll() throws Exception;

	public Room searchByRoomNo(int roomNo)throws Exception;

	public List<Room> searchByRoomType(List<String> roomType)throws Exception;

	public List<Room> searchByRoomSize(double minSize, double maxSize)throws Exception;

	public List<Room> searchByRoomPrice(int minPrice, int maxPrice)throws Exception;

	public List<Room> searchByFloor(int floor)throws Exception;

	public List<Room> searchByNumberPeople(int numberPeople)throws Exception;

	public List<Room> searchByNumberBeds(int minNum, int maxNum)throws Exception;

	public List<Room> searchByBedSize(List<String> BedSize)throws Exception;

}
