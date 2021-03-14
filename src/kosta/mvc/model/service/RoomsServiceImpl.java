package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;



public class RoomsServiceImpl implements RoomsService{
	RoomsDAO roomDAO=new RoomsDAOImpl();
	
	public List<Room> selectAll() throws SQLException{
		return roomDAO.selectAll();
	}
	
	public Room searchByRoomNo(int roomNo) throws SQLException{
		return roomDAO.searchByRoomNo(roomNo);
	}
	public List<Room> searchByRoomType(List<String> roomType) throws SQLException{
		return roomDAO.searchByRoomType(roomType);
	}
	
	public List<Room> searchByRoomSize(double minSize,double maxSize) throws SQLException{
		return roomDAO.searchByRoomSize(minSize, maxSize);
	}
	public List<Room> searchByRoomPrice(int minPrice,int maxPrice) throws SQLException{
		return roomDAO.searchByRoomPrice(minPrice, maxPrice);
	}
	public List<Room> searchByFloor(int floor) throws SQLException{
		return roomDAO.searchByFloor(floor);
	}
	
	public List<Room> searchByNumberBeds(int minNum,int maxNum) throws SQLException{
		return roomDAO.searchByNumberBeds(minNum, maxNum);
	}
	

	@Override
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople) throws SQLException{
		// TODO Auto-generated method stub
		return roomDAO.searchByNumberPeople(minNbPeople, maxNbPeople);
	}

	@Override
	public List<Room> searchByBreakfastStat(boolean bfStat) throws SQLException {
		// TODO Auto-generated method stub
		return roomDAO.searchByBreakfastStat(bfStat);
	}

	@Override
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws Exception {
		Reservation rv=new Reservation(0, null, 0, checkinDate, checkoutDate, 0, 0, 0);
		RsrvtDAOImpl.isDuplicatedReser(null, rv);
		
		return null;
	}

}
