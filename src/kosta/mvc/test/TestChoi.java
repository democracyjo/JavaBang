package kosta.mvc.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;

public class TestChoi {

	public static void main(String[] args) {
	//	MenuView.menu();
		/*
		WishDAO wh=new WishDAOImpl();
		try {
		List<Wish> list=wh.selectWishByUserId("minjoo");
		System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		//MenuView.menu();
		// TODO Auto-generated method stub
		/*
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
		*/
		/*
		Scanner sc=new Scanner(System.in);
		System.out.println("���೯¥�� ã��");
		System.out.print("üũ�� ��¥ : ");
		String checkinDate = sc.nextLine();

		System.out.print("üũ�ƿ� ��¥ : ");
		String checkoutDate = sc.nextLine();
		*/
		String checkinDate="2021-02-05";
		String checkoutDate="2021-01-07";
		
		Reservation rv = new Reservation(0, null, 0, checkinDate, checkoutDate, 0, 0, 3);
		RsrvtDAO rsDAO = new RsrvtDAOImpl();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date day1=null;
			Date day2=null;
			Date day3=null;
			Date day4=null;
			day1=format.parse(checkinDate);
			System.out.println("day1��?");
			System.out.println(day1);
			System.out.println(rsDAO.selectRsrvtByRoomNo(3));
			System.out.println(rv.getCheckinDate());
			System.out.println(rv.getCheckoutDate());
			
		boolean b=RsrvtDAOImpl.isDuplicatedReser(rsDAO.selectRsrvtByRoomNo(3), rv);
		System.out.println(b);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	//	rc.searchByResDate("2021/01/05", "2021/01/11", false);
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
