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
			
			System.out.println("��ȣã��");
			Room rm=dao.searchByRoomNo(1);
			System.out.println(rm);
			
			System.out.println("��Ÿ������ ã��");
			List<String> typeList = new ArrayList<>();
			typeList.add("�����");
			typeList.add("�����̾� �����");
			list=dao.searchByRoomType(typeList);
			System.out.println(list);
			
			System.out.println("�������� ã��");
			list=dao.searchByRoomSize(7.6, 12);
			System.out.println(list);
			
			System.out.println("�氡������ ã��");
			list=dao.searchByRoomPrice(70000, 120000);
			System.out.println(list);
			
			System.out.println("������ ã��");
			list=dao.searchByFloor(3);
			System.out.println(list);
			
			System.out.println("������� ã��");
			list=dao.searchByNumberPeople(4);
			System.out.println(list);
			
			System.out.println("ħ����� ã��");
			list=dao.searchByNumberBeds(5,6);
			System.out.println(list);
			
			System.out.println("��ħ�������� ã��");
			list=dao.searchByBreakfastStat(true);
			System.out.println(list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
