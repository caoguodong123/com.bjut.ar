package com.bjut.ar.service;

import com.bjut.ar.bean.Admin;
import com.bjut.ar.bean.User;

public interface AdminService {
    public Admin login(String account,String password);
}
