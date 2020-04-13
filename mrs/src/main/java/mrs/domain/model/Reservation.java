package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{

	private static final long serialVersionUID = -6557775226647678958L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer reservationId;
	
	public LocalTime startTime;
	public LocalTime endTime;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "reserved_date"),
		@JoinColumn(name = "room_id") })
	public ReservableRoom reservableRoom;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User user;
	
	public ReservableRoomId getReservableRoomId() 
	{
		return reservableRoom.reservableRoomId;
	}
	
	public boolean overlap(Reservation target) 
	{
		if (!Objects.equals(reservableRoom.reservableRoomId,
				target.getReservableRoomId()))
		{
			return false;			
		}
		
		if (startTime.equals(target.startTime) && endTime.equals(target.endTime)) {
			return true;
		}
		
		return target.endTime.isAfter(startTime) && endTime.isAfter(target.startTime);				
	}
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public ReservableRoom getReservableRoom() {
		return this.reservableRoom;
	}
	
	public void setReservableRoom(ReservableRoom reservableRoom) {
		this.reservableRoom = reservableRoom;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
