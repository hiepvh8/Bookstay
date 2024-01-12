package com.example.bookstay.serviceImp;

import com.example.bookstay.model.entity.Room;
import com.example.bookstay.repository.RoomRepository;
import com.example.bookstay.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }
}
