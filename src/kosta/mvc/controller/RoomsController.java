package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.model.service.RoomsService;
import kosta.mvc.model.service.RoomsServiceImpl;



public class RoomsController {
	private static RoomsService roomService=new RoomsServiceImpl();
	
	public static void selectAll() {
		
	}
	
	public static void searchByRoomNo(int roomNo) {
		
	}
	public static void searchByRoomType(List<String> roomType) {
		
	}
	
	public static void searchByRoomSize(int minSize,int maxSize) {
		
	}
	public static void searchByRoomPrice(int minPrice,int maxPrice) {
		
	}
	public static void searchByFloor(int floor) {
		
	}
	public static void searchByNumberPeople(int numberPeople) {
		
	}
	public static void searchByNumberBeds(int minNum,int maxNum) {
		
	}
	public static void searchByBedSize(List<String> BedSize) {

	}
	
}
