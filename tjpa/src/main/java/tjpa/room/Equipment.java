package tjpa.room;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

	private static final long serialVersionUID = -3423164252827575297L;

	@Id
	@Column(name = "equipment_id")
	public Integer equipmentId;
	
	@Column(name = "equipment_name")
	public String equipmentName;
	
	@Column(name = "equipment_count")
	public Integer equipmentCount;

	@Column(name = "equipment_remarks")
	public String equipmentRemarks;	
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	public Room room;
}
