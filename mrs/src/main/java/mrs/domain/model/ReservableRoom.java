package mrs.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "reservable_room")
public class ReservableRoom implements Serializable {

	private static final long serialVersionUID = -4375167871276853186L;

	@EmbeddedId
	public ReservableRoomId reservableRoomId;
	
	@ManyToOne
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	@MapsId("roomId")
	public MeetingRoom meetingRoom;
	
	public ReservableRoom(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}
	
	public ReservableRoom() {		
	}
	
}
