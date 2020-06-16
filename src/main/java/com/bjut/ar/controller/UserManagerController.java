package com.bjut.ar.controller;

import com.bjut.ar.bean.User;
import com.bjut.ar.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user_manager")
public class UserManagerController {
    @Autowired
    private UserService us;

    @RequestMapping("/getAll")
    public String getAllUser(Model model) {
        List<User> users = us.getAllUser();
        model.addAttribute("users", users);
        return "success";
    }

    @RequestMapping("/getUserByName")
    public String getUserByName(@RequestParam(value = "pn", defaultValue = "1", required = false) Integer pn,
                                String condition, Model model) {
        System.out.println(condition);
        System.out.println(pn);
        System.out.println("--------------------");
        PageHelper.startPage(pn, 4);
        List<User> users = us.getUserByName(condition);
        PageInfo<User> info = new PageInfo<>(users, 5);
        model.addAttribute("info", info);
        model.addAttribute("condition", condition);
        return "user_manager_search";
    }

    @RequestMapping("/toUserManager")
    public String showAllUser(@RequestParam(value = "pn", defaultValue = "1", required = false) Integer pn, Model model) {
        PageHelper.startPage(pn, 4);
        List<User> users = us.getAllUser();
        System.out.println(users);
        PageInfo<User> info = new PageInfo<>(users, 5);
        System.out.println(info);

        model.addAttribute("info", info);
        return "user_manager";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Integer pn,
                         @RequestParam(value = "flag", required = false, defaultValue = "1") Integer flag,
                         @RequestParam(value = "condition", required = false, defaultValue = "") String condition,
                         Model model) {
        User user = us.getUserById(id);
        model.addAttribute("user_edit", user);
        model.addAttribute("pn", pn);
        model.addAttribute("flag", flag);
        model.addAttribute("condition", condition);
        return "user_edit";
    }

    @RequestMapping("/edit")
    public String edit(@Valid User user, BindingResult result, Integer pn, Integer flag,
                       @RequestParam(value = "condition", required = false, defaultValue = "") String condition,Model model) {
        // 获取是否有校验错误
        boolean hasErrors = result.hasErrors();
        Map<String, Object> errorsMap = new HashMap<String, Object>();
        if (hasErrors) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {

                System.out.println("错误消息提示：" + fieldError.getDefaultMessage());
                System.out.println("错误的字段是？" + fieldError.getField());
                System.out.println(fieldError);
                System.out.println("------------------------");
                errorsMap.put(fieldError.getField(),
                        fieldError.getDefaultMessage());
            }
            model.addAttribute("errorInfo", errorsMap);
            System.out.println("有校验错误");
            us.editUser(user);
        }
        System.out.println(user);
        System.out.println(flag);
        System.out.println(condition);
        if (flag == 1)
            return "forward:/user_manager/toUserManager?pn=" + pn + "";
        else
            return "forward:/user_manager/getUserByName";
    }

    @RequestMapping("/delete")
    public String delete(Integer id, Integer pn,
                         @RequestParam(value = "flag", required = false, defaultValue = "1") Integer flag,
                         @RequestParam(value = "condition", required = false, defaultValue = "") String condition) {
        us.deleteUserById(id);
        if (flag == 1)
            return "forward:/user_manager/toUserManager?pn=" + pn + "";
        else
            return "forward:/user_manager/getUserByName";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Integer pn, Model model) {
        model.addAttribute("pn", pn);
        return "user_add";
    }

    @RequestMapping("/add")
    public String add(User user) {
        System.out.println("safasdfasdfsdfasfsadfsad");
        us.addUser(user);
        List<User> users = us.getAllUser();
        Integer pn;
        if (users.size() % 4 == 0) {
            pn = users.size() / 4;
        } else {
            pn = users.size() / 4 + 1;
        }
        return "forward:/user_manager/toUserManager?pn=" + pn + "";
    }
}
