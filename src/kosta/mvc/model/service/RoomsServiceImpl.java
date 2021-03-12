package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dto.Room;



public class RoomsServiceImpl implements RoomsService{
	RoomsDAO roomDAO=new RoomsDAOImpl();
	
	public List<Room> selectAll() {
		return null;
	}
	
	public Room searchByRoomNo(int roomNo) {
		return null;
	}
	public List<Room> searchByRoomType(List<String> roomType) {
		return null;
	}
	
	public List<Room> searchByRoomSize(int minSize,int maxSize) {
		return null;
	}
	public List<Room> searchByRoomPrice(int minPrice,int maxPrice) {
		return null;
	}
	public List<Room> searchByFloor(int floor) {
		return null;
	}
	
	public List<Room> searchByNumberBeds(int minNum,int maxNum) {
		return null;
	}
	public List<Room> searchByBedSize(List<String> BedSize) {
		return null;
	}

	@Override
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
