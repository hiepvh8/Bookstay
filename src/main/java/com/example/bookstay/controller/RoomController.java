package com.example.bookstay.controller;

import com.example.bookstay.model.entity.Hotel;
import com.example.bookstay.model.entity.Room;
import com.example.bookstay.service.HotelService;
import com.example.bookstay.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel")
public class RoomController {

    private final RoomService roomService;
    private final HotelService hotelService;

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }

    @GetMapping("/{hotelId}/add_room")
    public String showAddRoomForm(@PathVariable Long hotelId, Model model) {
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("newRoom", new Room());
        return "add_room";
    }

    @PostMapping("/{hotelId}/add_room")
    public String addRoom(@PathVariable Long hotelId, @ModelAttribute("newRoom") Room newRoom) {
        try {
            Hotel hotel = hotelService.getHotelById(hotelId);
            newRoom.setHotel(hotel);
            roomService.save(newRoom);
            return "redirect:/hotel/" + hotelId;
        } catch (Exception e) {
            // Xử lý lỗi nếu có
            // Có thể thêm thông báo lỗi và chuyển hướng người dùng đến một trang lỗi
            return "redirect:/error";
        }
    }

}
