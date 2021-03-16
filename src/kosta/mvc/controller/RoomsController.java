package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Room;
import kosta.mvc.model.service.RoomsService;
import kosta.mvc.model.service.RoomsServiceImpl;
import kosta.mvc.model.service.RsrvtService;
import kosta.mvc.model.service.RsrvtServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class RoomsController {
	// ���
	
	/**
	 * �뼭�񽺸� �ҷ����� ���� ����, roomList�� ����� �˻��� �����ϱ� ���Ѱ�
	 */
	private static RoomsService roomService = new RoomsServiceImpl();
	
	private static List<Room> roomList;

	public static void refresh() {
		SuccessView.messagePrint("�ε� ���Դϴ�.");
		try {
			List<Room> list = roomService.selectAll();
			roomList = list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * ��ü ����
	 */
	public static void selectAll() {
		try {
			List<Room> list = roomService.selectAll();
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ���ȣ�� �˻�
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
	 * 
	 * @param roomType
	 * @param searchWthRsl
	 */
	public static void searchByRoomType(List<String> roomType, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByRoomType(roomType);
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * minSize~max������ ������ �� �˻�
	 * 
	 * @param minSize
	 * @param maxSize
	 * @param searchWthRsl
	 */
	public static void searchByRoomSize(double minSize, double maxSize, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByRoomSize(minSize, maxSize);
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByRoomPrice(int minPrice, int maxPrice, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByRoomPrice(minPrice, maxPrice);
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByFloor(int minFloor,int maxFloor, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByFloor(minFloor, maxFloor);
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByNumberPeople(int minNum, int maxNum, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByNumberPeople(minNum, maxNum);
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchByNumberBeds(int minNum, int maxNum, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByNumberBeds(minNum, maxNum);

			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void searchByBreakfastStat(boolean bfStat, boolean searchWthRsl) {
		try {
			List<Room> list = roomService.searchByBreakfastStat(bfStat);
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void searchByResDate(String checkinDate, String checkoutDate, boolean searchWthRsl) {
		try {
			RsrvtService rs=new RsrvtServiceImpl();
			if(!rs.diffOfDate(checkinDate, checkoutDate)) {
				throw new SQLException("üũ�� ��¥�� üũ�ƿ� ��¥���� ����� �մϴ�.");
			}
			List<Room> list = roomService.searchByResDate(checkinDate, checkoutDate);
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomList(list);
			roomList = list;
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());

		}
	}

	public static void printRoomTypeList(boolean searchWthRsl) {
		try {
			List<Room> list = roomService.selectAll();
			if (searchWthRsl) {
				list.retainAll(roomList);
			}
			SuccessView.printRoomTypeList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static Object getMin(int srcE) {
		switch (srcE) {
		case 1:
		{
			double min = 10000;
			for (Room rm : roomList) {
				if (rm.getSize() < min) {
					min = rm.getSize();
				}
			}
			return min;
		}
		case 2:
			break;
		case 3:
		{
			int min=1000000000;
			for (Room rm : roomList) {
				if (rm.getPrice() < min) {
					min = rm.getPrice();
				}
			}
			return min;
		}
		case 4:
		{
			int min=1000;
			for (Room rm : roomList) {
				if (rm.getFloor() < min) {
					min = rm.getFloor();
				}
			}
			return min;
		}
		case 5:
		{
			int min=100;
			for (Room rm : roomList) {
				if (rm.getAprprNmbP() < min) {
					min = rm.getAprprNmbP();
				}
			}
			return min;
		}
		case 6:
		{
			int min=100;
			for (Room rm : roomList) {
				if (rm.getNumberBeds() < min) {
					min = rm.getNumberBeds();
				}
			}
			return min;
		}
		default:
			return null;
		}
		return null;
	}
	
	public static Object getMax(int srcE) {
		switch (srcE) {
		case 1:
		{
			double max = 0;
			for (Room rm : roomList) {
				if (rm.getSize() > max) {
					max = rm.getSize();
				}
			}
			return max;
		}
		case 2:
			break;
		case 3:
		{
			int max=0;
			for (Room rm : roomList) {
				if (rm.getPrice() > max) {
					max = rm.getPrice();
				}
			}
			return max;
		}
		case 4:
		{
			int max=0;
			for (Room rm : roomList) {
				if (rm.getFloor() > max) {
					max = rm.getFloor();
				}
			}
			return max;
		}
		case 5:
		{
			int max=0;
			for (Room rm : roomList) {
				if (rm.getAprprNmbP() > max) {
					max = rm.getAprprNmbP();
				}
			}
			return max;
		}
		case 6:
		{
			int max=0;
			for (Room rm : roomList) {
				if (rm.getNumberBeds() > max) {
					max = rm.getNumberBeds();
				}
			}
			return max;
		}
		default:
			return null;
		}
		return null;
	}
}