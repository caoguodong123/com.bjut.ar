package com.bjut.ar.service.impl;

import com.bjut.ar.bean.Admin;
import com.bjut.ar.dao.AdminDao;
import com.bjut.ar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao ad;

    @Override
    public Admin login(String account, String password) {
        return ad.getAdmin(account, password);
    }
}
