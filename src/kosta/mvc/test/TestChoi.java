package kosta.mvc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dto.Room;

public class TestChoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoomsDAO dao = new RoomsDAOImpl();
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
			list=dao.searchByNumberPeople(4);
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
	}

}
