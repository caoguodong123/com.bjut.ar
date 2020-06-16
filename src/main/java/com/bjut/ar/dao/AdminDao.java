package com.bjut.ar.dao;

import com.bjut.ar.bean.Admin;
import com.bjut.ar.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    public Admin getAdmin(@Param("account") String account, @Param("password") String password);
}
