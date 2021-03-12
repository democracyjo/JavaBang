package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dto.RoomDTO;



public interface RoomsService {
	public List<RoomDTO> selectAll();
	
	public RoomDTO searchByRoomNo(int roomNo);
	/**
	 * 여러 룸타입에 해당하는 방 리스트를 뽑는다.
	 * @param roomType
	 * @return
	 */
	public List<RoomDTO> searchByRoomType(List<String> roomType);
	/**
	 * 최소 사이즈~ 최대 사이즈 사이의 방 리스트를 뽑는다.
	 * @param minSize
	 * @param maxSize
	 * @return
	 */
	public List<RoomDTO> searchByRoomSize(int minSize, int maxSize);
	/**
	 * 최소가격과 최대가격 사이의 방리스트
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<RoomDTO> searchByRoomPrice(int minPrice, int maxPrice);
	/**
	 * 각 층에 대한 방리스트
	 * @param floor
	 * @return
	 */
	public List<RoomDTO> searchByFloor(int floor);
	/**
	 * 각 방의 적정인원수가 min~max사이인것을 구한다.
	 * @param numberPeople
	 * @return
	 */
	public List<RoomDTO> searchByNumberPeople(int minNbPeople, int maxNbPeople);
	/**
	 * 침대수가 min~max사이인것을 구한다.
	 * @param minNum
	 * @param maxNum
	 * @return
	 */
	public List<RoomDTO> searchByNumberBeds(int minNum, int maxNum);
	/**
	 * 침대 사이즈들을 여럿골라서 거기 해당하는걸 구한다.
	 * @param BedSize
	 * @return
	 */
	public List<RoomDTO> searchByBedSize(List<String> BedSize);
}
