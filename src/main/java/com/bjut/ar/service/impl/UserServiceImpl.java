package com.bjut.ar.service.impl;

import com.bjut.ar.bean.User;
import com.bjut.ar.dao.UserDao;
import com.bjut.ar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;

    @Override
    public List<User> getAllUser() {
        return ud.getAllUser();
    }

    @Override
    public User getUserById(Integer id) {
        User user = ud.getUserById(id);
        return user;
    }

    @Override
    public boolean editUser(User user) {
        return ud.editUser(user);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return ud.deleteUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        return ud.addUser(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return ud.getUserByName(name);
    }
}
