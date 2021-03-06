package tjpa.room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer>{
	Room findByRoomId(Integer roomId);
}
