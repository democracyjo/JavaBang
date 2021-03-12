package kosta.mvc.model.dao;

import java.util.List;

import kosta.mvc.model.dto.RoomDTO;



public interface RoomsDAO {

	public List<RoomDTO> selectAll();

	public RoomDTO searchByRoomNo(int roomNo);

	public List<RoomDTO> searchByRoomType(List<String> roomType);

	public List<RoomDTO> searchByRoomSize(int minSize, int maxSize);

	public List<RoomDTO> searchByRoomPrice(int minPrice, int maxPrice);

	public List<RoomDTO> searchByFloor(int floor);

	public List<RoomDTO> searchByNumberPeople(int numberPeople);

	public List<RoomDTO> searchByNumberBeds(int minNum, int maxNum);

	public List<RoomDTO> searchByBedSize(List<String> BedSize);

}
