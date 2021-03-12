package kosta.mvc.model.dao;

import java.util.List;

import kosta.mvc.model.dto.Room;



public interface RoomsDAO {

	public List<Room> selectAll();

	public Room searchByRoomNo(int roomNo);

	public List<Room> searchByRoomType(List<String> roomType);

	public List<Room> searchByRoomSize(int minSize, int maxSize);

	public List<Room> searchByRoomPrice(int minPrice, int maxPrice);

	public List<Room> searchByFloor(int floor);

	public List<Room> searchByNumberPeople(int numberPeople);

	public List<Room> searchByNumberBeds(int minNum, int maxNum);

	public List<Room> searchByBedSize(List<String> BedSize);

}
