package tjpa.room;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room implements Serializable {

	private static final long serialVersionUID = 7181958936120063274L;

	@Id
	@Column(name = "room_id")
	public Integer roomId;
	
	@Column(name = "room_name")
	public String roomName;
	
	@Column(name = "capacity")
	public Integer capacity;
	
	@Column(name = "build_date")
	public LocalDate buildDate;	
	
	@OneToMany(mappedBy="room", cascade=CascadeType.ALL)
	public List<Equipment> equipments;

}
