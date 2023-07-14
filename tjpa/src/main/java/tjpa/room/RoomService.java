package tjpa.room;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class RoomService {

	@PersistenceContext
	EntityManager entityManager;
	
//	public Room getRoom(Integer roomId) {
//		Room room = entityManager.find(Room.class, roomId);
//		return room;
//	}

	//@Transactional
	//@Transactional(readOnly = true, propagation=Propagation.REQUIRED)

	@Transactional
	public List<Room> getAllRoom() {
		String jpql = "SELECT r FROM Room r";
		TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
		return query.getResultList();
	}
	
	
	@Transactional
	public List<Equipment> getAllEquipment() {
		String jpql = "SELECT r FROM Equipment r";
		TypedQuery<Equipment> query = entityManager.createQuery(jpql, Equipment.class);
		return query.getResultList();
	}	
	
}
