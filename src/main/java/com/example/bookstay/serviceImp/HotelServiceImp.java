package com.example.bookstay.serviceImp;

import com.example.bookstay.model.entity.Hotel;
import com.example.bookstay.repository.HotelRepository;
import com.example.bookstay.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }
}
