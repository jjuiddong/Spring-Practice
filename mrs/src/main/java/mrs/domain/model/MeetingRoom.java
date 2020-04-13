package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "meeting_room")
public class MeetingRoom implements Serializable {

	private static final long serialVersionUID = -5600244619396348747L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	public Integer roomId;
	
	@Column(name = "room_name")
	public  String roomName;

}
