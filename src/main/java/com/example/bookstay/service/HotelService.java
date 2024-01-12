package com.example.bookstay.service;

import com.example.bookstay.model.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Long id);
    void saveHotel(Hotel hotel);
}
