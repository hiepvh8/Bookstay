package com.example.bookstay.service;

import com.example.bookstay.model.entity.Room;

import java.util.List;

public interface RoomService {


    List<Room> getAllRooms();

    List<Room> getRoomsByHotelId(Long hotelId);

    void save(Room room);
}
