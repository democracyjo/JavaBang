package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dto.RoomDTO;



public interface RoomsService {
	public List<RoomDTO> selectAll();
	
	public RoomDTO searchByRoomNo(int roomNo);
	/**
	 * ���� ��Ÿ�Կ� �ش��ϴ� �� ����Ʈ�� �̴´�.
	 * @param roomType
	 * @return
	 */
	public List<RoomDTO> searchByRoomType(List<String> roomType);
	/**
	 * �ּ� ������~ �ִ� ������ ������ �� ����Ʈ�� �̴´�.
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public List<RoomDTO> searchByRoomSize(int minSize, int maxSize);
	/**
	 * �ּҰ��ݰ� �ִ밡�� ������ �渮��Ʈ
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<RoomDTO> searchByRoomPrice(int minPrice, int maxPrice);
	/**
	 * �� ���� ���� �渮��Ʈ
	 * @param floor
	 * @return
	 */
	public List<RoomDTO> searchByFloor(int floor);
	/**
	 * �� ���� �����ο����� min~max�����ΰ��� ���Ѵ�.
	 * @param numberPeople
	 * @return
	 */
	public List<RoomDTO> searchByNumberPeople(int minNbPeople, int maxNbPeople);
	/**
	 * ħ����� min~max�����ΰ��� ���Ѵ�.
	 * @param minNum
	 * @param maxNum
	 * @return
	 */
	public List<RoomDTO> searchByNumberBeds(int minNum, int maxNum);
	/**
	 * ħ�� ��������� ������� �ű� �ش��ϴ°� ���Ѵ�.
	 * @param BedSize
	 * @return
	 */
	public List<RoomDTO> searchByBedSize(List<String> BedSize);
}
