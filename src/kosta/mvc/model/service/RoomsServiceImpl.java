package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dto.RoomDTO;



public class RoomsServiceImpl implements RoomsService{
	RoomsDAO roomDAO=new RoomsDAOImpl();
	
	public List<RoomDTO> selectAll() {
		return null;
	}
	
	public RoomDTO searchByRoomNo(int roomNo) {
		return null;
	}
	public List<RoomDTO> searchByRoomType(List<String> roomType) {
		return null;
	}
	
	public List<RoomDTO> searchByRoomSize(int minSize,int maxSize) {
		return null;
	}
	public List<RoomDTO> searchByRoomPrice(int minPrice,int maxPrice) {
		return null;
	}
	public List<RoomDTO> searchByFloor(int floor) {
		return null;
	}
	
	public List<RoomDTO> searchByNumberBeds(int minNum,int maxNum) {
		return null;
	}
	public List<RoomDTO> searchByBedSize(List<String> BedSize) {
		return null;
	}

	@Override
	public List<RoomDTO> searchByNumberPeople(int minNbPeople, int maxNbPeople) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
