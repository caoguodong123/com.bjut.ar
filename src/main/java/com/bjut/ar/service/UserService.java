package com.bjut.ar.service;

import com.bjut.ar.bean.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();

    public User getUserById(Integer id);

    public boolean editUser(User user);

    public boolean deleteUserById(Integer id);

    public boolean addUser(User user);

    public List<User> getUserByName(String name);
}
