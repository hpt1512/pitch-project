package com.example.pitchproject.service;

import com.example.pitchproject.bean.Pitch;
import com.example.pitchproject.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PitchServiceImpl implements IBaseService<Pitch> {
    @Autowired
    IBaseRepository<Pitch> pitchRepository;

    @Override
    public List<Pitch> findAll() {
        return pitchRepository.findAll();
    }

    @Override
    public void insert(Pitch pitch) throws SQLException {
        pitchRepository.insert(pitch);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return pitchRepository.delete(id);
    }

    @Override
    public boolean update(Pitch pitch) throws SQLException {
        return pitchRepository.update(pitch);
    }

    @Override
    public Pitch getById(int id) {
        return pitchRepository.getById(id);
    }

    @Override
    public List<Pitch> findByName(String name) {
        return pitchRepository.findByName(name);
    }
}
