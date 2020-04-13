package mrs.domain.service.reservation;

public class UnavailiableReservationException extends RuntimeException {
	
	private static final long serialVersionUID = 2777998102191495730L;

	public UnavailiableReservationException(String message) {
		super(message);
	}
}
