package kosta.mvc.test;

import java.util.ArrayList;
import java.util.List;

import kosta.mvc.controller.RoomsController;
import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;
import kosta.mvc.view.MenuView;

public class TestChoi {

	public static void main(String[] args) {
		TestDongso.menu();
		//MenuView.menu();
		// TODO Auto-generated method stub
		/*
		List<Room> list=null;
		RoomsDAO dao = new RoomsDAOImpl();
		RoomsController rc=new RoomsController();
		rc.selectAll();
		
		System.out.println("방 사이즈 검색");
		rc.searchByRoomSize(6, 8, false);
		
		System.out.println("방타입으로 찾기");
		List<String> typeList = new ArrayList<>();
		typeList.add("더블룸");
		typeList.add("스위트 더블룸");
		rc.searchByRoomType(typeList, false);
		
		System.out.println("방가격으로 찾기");
		rc.searchByRoomPrice(70000, 150000,false);
		
		
		System.out.println("층수로 찾기");
		rc.searchByFloor(1, false);
		
		System.out.println("사람수로 찾기");
		rc.searchByNumberPeople(4, 4, false);
		
		System.out.println("침대수로 찾기");
		rc.searchByNumberBeds(5,6,false);
		
		
		System.out.println("아침가능으로 찾기");
		rc.searchByBreakfastStat(true,false);
		
		System.out.println("결과내 검색");
		System.out.println("침대수로 찾기");
		rc.searchByNumberBeds(5,6,true);
		*/
		/*
		System.out.println("예약날짜로 찾기");
		String checkinDate="2021-01-05";
		String checkoutDate="2021-01-11";
		Reservation rv = new Reservation(1, null, 0, checkinDate, checkoutDate, 0, 0, 1);
		RsrvtDAO rsDAO = new RsrvtDAOImpl();
		try {
			System.out.println(rsDAO.selectRsrvtByRoomNo(1));
			System.out.println(rv.getCheckinDate());
			System.out.println(rv.getCheckoutDate());
			
		boolean b=RsrvtDAOImpl.isDuplicatedReser(rsDAO.selectRsrvtByRoomNo(1), rv);
		System.out.println(b);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		
		
	//	rc.searchByResDate("2021/01/05", "2021/01/11", false);
		/*
		try {
			
			List<Room> list = dao.selectAll();
			System.out.println(list);
			
			System.out.println("번호찾기");
			Room rm=dao.searchByRoomNo(1);
			System.out.println(rm);
			
			System.out.println("방타입으로 찾기");
			List<String> typeList = new ArrayList<>();
			typeList.add("더블룸");
			typeList.add("프리미어 더블룸");
			list=dao.searchByRoomType(typeList);
			System.out.println(list);
			
			System.out.println("방사이즈로 찾기");
			list=dao.searchByRoomSize(7.6, 12);
			System.out.println(list);
			
			System.out.println("방가격으로 찾기");
			list=dao.searchByRoomPrice(70000, 120000);
			System.out.println(list);
			
			System.out.println("층수로 찾기");
			list=dao.searchByFloor(3);
			System.out.println(list);
			
			System.out.println("사람수로 찾기");
			list=dao.searchByNumberPeople(4,5);
			System.out.println(list);
			
			System.out.println("침대수로 찾기");
			list=dao.searchByNumberBeds(5,6);
			System.out.println(list);
			
			System.out.println("아침가능으로 찾기");
			list=dao.searchByBreakfastStat(true);
			System.out.println(list);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		*/
	}

}
