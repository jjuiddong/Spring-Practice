package tjpa.room;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomServiceRepo {

	@Autowired
	RoomRepo roomRepo;
	
	@Autowired
	EquipmentRepo equipmentRepo;

	//@Transactional
	//@Transactional(readOnly = true, propagation=Propagation.REQUIRED)

	@Transactional
	public List<Room> getAllRoom() {
		List<Room> all = roomRepo.findAll();
		return all;
	}	
	
	@Transactional
	public List<Equipment> getAllEquipment() {
		List<Equipment> all = equipmentRepo.findAll();
		return all;
	}
	
	@Transactional
	public Room getRoom(Integer roomId) {
		Room room = roomRepo.findByRoomId(roomId);
		return room;
	}
	
	
}
