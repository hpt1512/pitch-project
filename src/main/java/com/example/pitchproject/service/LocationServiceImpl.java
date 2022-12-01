package com.example.pitchproject.service;

import com.example.pitchproject.bean.Location;
import com.example.pitchproject.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LocationServiceImpl implements IBaseService<Location> {
    @Autowired
    IBaseRepository<Location> locationRepository;
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public void insert(Location location) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Location location) throws SQLException {
        return false;
    }

    @Override
    public Location getById(int id) {
        return null;
    }

    @Override
    public List<Location> findByName(String name) {
        return null;
    }
}
