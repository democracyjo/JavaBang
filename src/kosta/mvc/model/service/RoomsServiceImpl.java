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
	ReviewService rs=new ReviewServiceImpl();
	
	public List<Room> selectAll() throws SQLException{
		List<Room> list= roomDAO.selectAll();
		for(Room rm : list) {
			rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
		}
		return list;
	}
	
	public Room searchByRoomNo(int roomNo) throws Exception{
		Room rm= roomDAO.searchByRoomNo(roomNo);
		if(rm!=null) {
			rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			return rm;
		}else {
			throw new NotFoundException("검색 한 방 번호가 없습니다");
		}
	}
	public List<Room> searchByRoomType(List<String> roomType) throws Exception{
		List<Room> list=roomDAO.searchByRoomType(roomType);
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방타입이 없습니다");
		}
		
	}
	
	public List<Room> searchByRoomSize(double minSize,double maxSize) throws Exception{
		List<Room> list= roomDAO.searchByRoomSize(minSize, maxSize);
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방이 없습니다");
		}
	}
	public List<Room> searchByRoomPrice(int minPrice,int maxPrice) throws Exception{
		List<Room> list= roomDAO.searchByRoomPrice(minPrice, maxPrice);
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방이 없습니다");
		}
	}
	public List<Room> searchByFloor(int floor) throws Exception{
		List<Room> list= roomDAO.searchByFloor(floor);
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방이 없습니다");
		}
	}
	
	public List<Room> searchByNumberBeds(int minNum,int maxNum) throws Exception{
		List<Room> list= roomDAO.searchByNumberBeds(minNum, maxNum);
		
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방이 없습니다");
		}
	}
	

	@Override
	public List<Room> searchByNumberPeople(int minNbPeople, int maxNbPeople) throws Exception{
		// TODO Auto-generated method stub
		List<Room> list= roomDAO.searchByNumberPeople(minNbPeople, maxNbPeople);
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방이 없습니다");
		}
	}

	@Override
	public List<Room> searchByBreakfastStat(boolean bfStat) throws Exception {
		// TODO Auto-generated method stub
		List<Room> list= roomDAO.searchByBreakfastStat(bfStat);
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방이 없습니다");
		}
	}

	@Override
	public List<Room> searchByResDate(String checkinDate, String checkoutDate) throws Exception {
		List<Room> list= roomDAO.searchByResDate(checkinDate, checkoutDate);
		if(list!=null) {
			for(Room rm : list) {
				rm.setAvgScore(rs.getAvgP(rm.getRoomNo()));
			}

			return list;
		}else {
			throw new NotFoundException("검색 한 방이 없습니다");
		}
	}

}
