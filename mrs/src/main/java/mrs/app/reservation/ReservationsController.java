package mrs.app.reservation;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.User;
import mrs.domain.service.reservation.AlreadyReservedException;
import mrs.domain.service.reservation.ReservationService;
import mrs.domain.service.reservation.UnavailiableReservationException;
import mrs.domain.service.room.RoomService;
import mrs.domain.service.user.ReservationUserDetails;

@Controller
@RequestMapping("reservation/{date}/{roomId}")
public class ReservationsController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	ReservationService reservationService;
	
	@ModelAttribute
	ReservationForm setUpForm() {
		ReservationForm form = new ReservationForm();
		form.setStartTime(LocalTime.of(9, 0));
		form.setEndTime(LocalTime.of(10, 0));
		return form;
	}
	
    @RequestMapping(method = RequestMethod.GET)
    String reserveForm(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    		@PathVariable("date") LocalDate date,
            @PathVariable("roomId") Integer roomId, Model model) 
    {
        ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);
        List<Reservation> reservations = reservationService.findReservations(reservableRoomId);
        
        List<LocalTime> timeList = Stream
                .iterate(LocalTime.of(0, 0), t -> t.plusMinutes(30))
                .limit(24 * 2).collect(Collectors.toList());
        
        model.addAttribute("room", roomService.findMeetingRoom(roomId));
        model.addAttribute("reservations", reservations);
        model.addAttribute("timeList", timeList);
        //model.addAttribute("user", dummyUser());
        
        return "reservation/reserveForm";
    }
    

    @RequestMapping(method = RequestMethod.POST)
    String reserve(@Validated ReservationForm form, BindingResult bindingResult,
    		@AuthenticationPrincipal ReservationUserDetails userDetails,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    		@PathVariable("date") LocalDate date,
            @PathVariable("roomId") Integer roomId, Model model) 
    {
        if (bindingResult.hasErrors()) {
            return reserveForm(date, roomId, model);
        }
        
        ReservableRoom reservableRoom = new ReservableRoom(new ReservableRoomId(roomId, date));
        Reservation reservation = new Reservation();
        reservation.setStartTime(form.getStartTime());
        reservation.setEndTime(form.getEndTime());
        reservation.setReservableRoom(reservableRoom);
        reservation.setUser(userDetails.getUser());
        //reservation.setUser(dummyUser());
        try {
            reservationService.reserve(reservation);
        } catch (UnavailiableReservationException | AlreadyReservedException e) {
            model.addAttribute("error", e.getMessage());
            return reserveForm(date, roomId, model);
        }

        return "redirect:/reservation/{date}/{roomId}";
    }    
    
    
    @RequestMapping(method = RequestMethod.POST, params = "cancel")
    String cancel(@AuthenticationPrincipal ReservationUserDetails userDetails,
    		@RequestParam("reservationId") Integer reservationId,
    		@PathVariable("roomId") Integer roomId,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    		@PathVariable("date") LocalDate date,
            Model model) 
    {
    	//User user = dummyUser();
    	User user = userDetails.getUser();
    	try {
    		reservationService.cancel(reservationId, user);
    	} catch(AccessDeniedException e) {
            model.addAttribute("error", e.getMessage());
            return reserveForm(date, roomId, model);
    	}    	

    	return "redirect:/reservation/{date}/{roomId}";    	
    }
    
    
//     private User dummyUser() {
//	     User user = new User();
//	     user.userId = "Go Damdeok";
//	     user.firstName = "담덕";
//	     user.lastName = "고";
//	     user.roleName = RoleName.USER;
//	     return user;
//     }    
    
}
