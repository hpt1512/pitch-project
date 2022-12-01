package com.example.pitchproject.service;

import com.example.pitchproject.bean.Booking;
import com.example.pitchproject.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookingServiceImpl implements IBaseService<Booking> {
    @Autowired
    IBaseRepository<Booking> bookingRepository;
    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
    @Override
    public void insert(Booking booking) throws SQLException {
        bookingRepository.insert(booking);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Booking booking) throws SQLException {
        return false;
    }

    @Override
    public Booking getById(int id) {
        return null;
    }

    @Override
    public List<Booking> findByName(String name) {
        return null;
    }
}
