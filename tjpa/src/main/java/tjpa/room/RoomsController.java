package tjpa.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("rooms")
public class RoomsController {
	@Autowired
	RoomServiceRepo roomService;

	@RequestMapping(method = RequestMethod.GET)
	String listRooms(Model model) 
	{
		LocalDate today = LocalDate.now();
		List<Room> rooms = roomService.getAllRoom();
		List<Equipment> equips = roomService.getAllEquipment();
		Room room = roomService.getRoom(1);
		model.addAttribute("date", today);
		model.addAttribute("room", room);
		model.addAttribute("rooms", rooms);
		model.addAttribute("equips", equips);
		return "room/listRooms";
	}
	
	
//	@RequestMapping(value = "{date}", method = RequestMethod.GET)
//	String listRooms(
//			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
//			@PathVariable("date")
//			LocalDate date, Model model) 
//	{
//		List<ReservableRoom> rooms = roomService.findReservableRooms(date);
//		model.addAttribute("date", date);
//		model.addAttribute("rooms", rooms);
//		return "room/listRooms";
//	}

}
