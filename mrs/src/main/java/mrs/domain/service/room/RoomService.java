package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.MeetingRoomRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class RoomService {
	
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	
	public List<ReservableRoom> findReservableRooms(LocalDate date) {
		return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date); 
	}
	
	public MeetingRoom findMeetingRoom(Integer roomId) {
		Optional<MeetingRoom> room = meetingRoomRepository.findById(roomId);
		return (room.get() == null)? null : room.get();
	}

}
