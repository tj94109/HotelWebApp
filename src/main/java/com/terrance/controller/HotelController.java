package com.terrance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.terrance.entity.Guest;
import com.terrance.entity.Hotel;
import com.terrance.entity.Room;
import com.terrance.services.*;


@Controller
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	Guest guest;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message2", " Click here to choose one of our hotels");
		return "index";
	}

	@RequestMapping("/Hotels")
	public String listHotels(Model model)
	{
		List<Hotel> listHotels=hotelService.getHotels();
		model.addAttribute("hotels",listHotels);
		
		return "Hotel_List";
	}

	@RequestMapping("/cancelled")
	public String showCancelled(Model model)
	{
		System.out.println(guest.getName());
		model.addAttribute("message","Guest");
		return "cancelled";
	}
	
	@RequestMapping("/Rooms")
	public String listBooks(Model model)
	{
		List<Room> listBooks=roomService.getList(1);
		model.addAttribute("rooms",listBooks);
		
		return "Room_List";
	}

	@RequestMapping("/Reservations/{id}")
	public ModelAndView showReservationPage(@PathVariable(name="id") int id)
	{
		
		ModelAndView mav = new ModelAndView("Reservations");
		
		Hotel h = hotelService.getHotel(id);
		Room room =roomService.getRoom(id);
		List<Room> rooms = hotelService.getRooms(id);
		
		mav.addObject("hotel",h);
		mav.addObject("rooms", rooms);
		mav.addObject("guest", guest);
	
		return mav;	
	}
	
	@RequestMapping(value="/reserve/{id}",method = RequestMethod.POST)
	public String saveReservation(@ModelAttribute Guest guest, Model model, @PathVariable(name="id") int id)
	{
		model.addAttribute(guest);
		
		hotelService.addReservation(guest.getName(), guest.getSmoking(), guest.getBed(), id);
		return "redirect:/Confirmation";
	}

	@RequestMapping("/Confirmation")
	public String confirmationPage(@ModelAttribute Guest guest, Model model) {
		return "Confirmation";
	}

	@RequestMapping(value="/cancel/{id}",method = RequestMethod.POST)
	public String cancelReservation(@ModelAttribute Guest guest, Model model, @PathVariable(name="id") int id)
	{
		model.addAttribute(guest);
		hotelService.cancelReservation(guest.getName(), id);
		return "redirect:/cancelled";
	}
	//

}