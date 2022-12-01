package com.example.pitchproject.service;

import java.sql.SQLException;
import java.util.List;

public interface IBaseService<E> {
    List<E> findAll();
    void insert(E e) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(E e) throws SQLException;
    E getById(int id);
    List<E> findByName(String name);
}
