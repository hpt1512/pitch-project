package com.example.pitchproject.service;

import com.example.pitchproject.bean.Role;
import com.example.pitchproject.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoleServiceImpl implements IBaseService<Role> {
    @Autowired
    IBaseRepository<Role> roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void insert(Role role) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        return false;
    }

    @Override
    public Role getById(int id) {
        return null;
    }

    @Override
    public List<Role> findByName(String name) {
        return null;
    }
}
