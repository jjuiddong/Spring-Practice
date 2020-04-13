package mrs.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import mrs.domain.model.*;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;


public interface ReservableRoomRepository 
	extends JpaRepository<ReservableRoom, ReservableRoomId> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	ReservableRoom findOneForUpdateByReservableRoomId(
			ReservableRoomId reservableRoomId);
	
	List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(
			LocalDate reservedDate);	

}
