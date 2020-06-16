package com.bjut.ar.controller;

import com.bjut.ar.bean.Admin;
import com.bjut.ar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService as;

    @RequestMapping("/login")
    public String login(String account, String password, HttpServletRequest request, HttpSession session) {
        Admin admin = as.login(account, password);
        if (admin == null) {
            request.setAttribute("msg", "用户名或密码错误！");
            return "login";
        } else {
            session.setAttribute("admin", admin);
            return "login_success";
        }
    }
}
