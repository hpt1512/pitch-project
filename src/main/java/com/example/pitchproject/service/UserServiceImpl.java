package com.example.pitchproject.service;

import com.example.pitchproject.bean.User;
import com.example.pitchproject.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements IBaseService<User> {
    @Autowired
    IBaseRepository<User> userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void insert(User user) throws SQLException {
        userRepository.insert(user);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return userRepository.delete(id);
    }

    @Override
    public boolean update(User user) throws SQLException {
        return userRepository.update(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

//    public User checkLogin(Login login){
//        List<User> users = this.findAll();
//        for (User u: users) {
//            if(u.getUsername().equals(login.getUsername())
//                    && u.getPassword().equals(login.getPassword())){
//                return u;
//            }
//        }
//        return null;
//    }
}
