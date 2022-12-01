package com.example.pitchproject.service;

import com.example.pitchproject.bean.Company;
import com.example.pitchproject.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CompanyServiceImpl implements IBaseService<Company> {
    @Autowired
    IBaseRepository<Company> companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void insert(Company company) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Company company) throws SQLException {
        return false;
    }

    @Override
    public Company getById(int id) {
        return companyRepository.getById(id);
    }

    @Override
    public List<Company> findByName(String name) {
        return null;
    }
}
