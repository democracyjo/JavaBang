package kosta.mvc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kosta.mvc.controller.RoomsController;
import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dto.Room;

public class TestChoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
