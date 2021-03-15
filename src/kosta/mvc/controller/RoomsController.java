package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Room;
import kosta.mvc.model.service.RoomsService;
import kosta.mvc.model.service.RoomsServiceImpl;
import kosta.mvc.view.MenuView;
import kosta.mvc.view.SuccessView;

public class RoomsController {
	/**
	 * �뼭�񽺸� �ҷ����� ���� ����, roomList�� ����� �˻��� �����ϱ� ���Ѱ�
	 */
	private static RoomsService roomService = new RoomsServiceImpl();
	private static List<Room> roomList;
	
	/**
	 * ��ü ����
	 */
	public static void selectAll() {
		try {
			List<Room> list = roomService.selectAll();
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//���ȣ�� �˻�
	public static void searchByRoomNo(int roomNo) {
		try {
			Room rm = roomService.searchByRoomNo(roomNo);
			SuccessView.printMessage(rm.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * �� ������ ����Ʈ�� �޾ƿͼ� �˻�. searchWthRsl�� true�϶� ����� �˻�
	 * @param roomType
	 * @param searchWthRsl
	 */
	public static void searchByRoomType(List<String> roomType,boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByRoomType(roomType);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * minSize~max������ ������ �� �˻�
	 * @param minSize
	 * @param maxSize
	 * @param searchWthRsl
	 */
	public static void searchByRoomSize(double minSize, double maxSize, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByRoomSize(minSize, maxSize);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByRoomPrice(int minPrice, int maxPrice, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByRoomPrice(minPrice, maxPrice);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByFloor(int floor, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByFloor(floor);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByNumberPeople(int minNum, int maxNum, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByNumberPeople(minNum, maxNum);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByNumberBeds(int minNum, int maxNum, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByNumberBeds(minNum, maxNum);
			System.out.println(roomList);
			System.out.println(list);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByBreakfastStat(boolean bfStat, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByBreakfastStat(bfStat);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void searchByResDate(String checkinDate, String checkoutDate,boolean searchWthRsl ) {
		try {
			List<Room> list = roomService.searchByResDate(checkinDate, checkoutDate);
			if(searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList=list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	public static void selectAllWthRsl() {

	}

	public static void searchByRoomNoWthRsl(int roomNo) {

	}

	public static void searchByRoomTypeWthRsl(List<String> roomType) {

	}

	public static void searchByRoomSizeWthRsl(int minSize, int maxSize) {

	}

	public static void searchByRoomPriceWthRsl(int minPrice, int maxPrice) {

	}

	public static void searchByFloorWthRsl(int floor) {

	}

	public static void searchByNumberPeopleWthRsl(int minNum, int maxNum) {

	}

	public static void searchByNumberBedsWthRsl(int minNum, int maxNum) {

	}

	public static void searchByBreakfastStatWthRsl(boolean bfStat) {

	}
	*/
}