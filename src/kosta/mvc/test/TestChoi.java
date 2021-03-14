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
		
		System.out.println("�� ������ �˻�");
		rc.searchByRoomSize(6, 8, false);
		
		System.out.println("��Ÿ������ ã��");
		List<String> typeList = new ArrayList<>();
	   typeList.add("�����");
		typeList.add("����Ʈ �����");
		rc.searchByRoomType(typeList, false);
		
		System.out.println("�氡������ ã��");
		rc.searchByRoomPrice(70000, 150000,false);
		
		
		System.out.println("������ ã��");
		rc.searchByFloor(1, false);
		
		System.out.println("������� ã��");
		rc.searchByNumberPeople(4, 4, false);
		
		System.out.println("ħ����� ã��");
		rc.searchByNumberBeds(5,6,false);
		
		
		System.out.println("��ħ�������� ã��");
		rc.searchByBreakfastStat(true,false);
		
		System.out.println("����� �˻�");
		System.out.println("ħ����� ã��");
		rc.searchByNumberBeds(5,6,true);
		/*
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
			list=dao.searchByNumberPeople(4,5);
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
		*/
	}

}
