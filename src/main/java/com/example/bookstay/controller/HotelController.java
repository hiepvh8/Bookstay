package com.example.bookstay.controller;

import com.example.bookstay.model.entity.Hotel;
import com.example.bookstay.model.entity.Room;
import com.example.bookstay.service.HotelService;
import com.example.bookstay.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels", hotels);
        return "home";
    }

    @GetMapping("/hotel/{hotelId}")
    public String hotelDetail(@PathVariable Long hotelId, Model model) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        List<Room> rooms = hotel.getRooms();
        model.addAttribute("hotel", hotel);
        model.addAttribute("rooms", rooms);
        return "hotel_detail";
    }

    @GetMapping("/home/add_hotel")
    public String showAddHotelForm(Model model) {
        model.addAttribute("newHotel", new Hotel());
        return "add_hotel";
    }

    @PostMapping("/addHotel")
    public String addHotel(@ModelAttribute Hotel newHotel) {
        hotelService.saveHotel(newHotel); // Lưu hotel vào cơ sở dữ liệu
        return "redirect:/home"; // Chuyển hướng về trang chủ sau khi thêm mới hotel
    }

    @GetMapping("/hotel/{hotelId}/rooms")
    public String getAllRooms(@PathVariable Long hotelId, Model model) {
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("rooms", roomService.getRoomsByHotelId(hotelId));
        return "room_list";
    }



}

