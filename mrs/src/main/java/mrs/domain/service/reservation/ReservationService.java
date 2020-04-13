package mrs.domain.service.reservation;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.RoleName;
import mrs.domain.model.User;
import mrs.domain.repository.reservation.ReservationRepository;
import mrs.domain.repository.room.ReservableRoomRepository;


@Service
@Transactional
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	public List<Reservation> findReservations(ReservableRoomId reservableRoomId)
	{
		return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);				
	}

	public Reservation reserve(Reservation reservation)
	{
		ReservableRoomId reservableRoomId = reservation.getReservableRoomId();
		ReservableRoom reservable = reservableRoomRepository.
				findOneForUpdateByReservableRoomId(reservableRoomId);
		
		if (reservable == null) {
			throw new UnavailiableReservationException(
					"선택한 날짜와 회의실로 예약살 수 없습니다.");
		}
		
		boolean overlap = reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(
				reservableRoomId).stream().anyMatch(x -> x.overlap(reservation));
		if (overlap) {
			throw new AlreadyReservedException(
					"입력한 시간대에 이미 예약된 건이 있습니다.");
		}
		
		reservationRepository.save(reservation);
		return reservation;
	}
	
	public void cancel(Integer reservationId, User requestUser) throws AccessDeniedException
	{
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		if (RoleName.ADMIN != requestUser.roleName
			&& !Objects.equals(reservation.get().user.userId, requestUser.userId)) {
			throw new AccessDeniedException("예약을 취소할 수 없습니다."); 
		}
		reservationRepository.delete(reservation.get());
	}	
	
	
}
