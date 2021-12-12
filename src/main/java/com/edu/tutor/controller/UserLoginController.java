package com.edu.tutor.controller;

import com.edu.tutor.core.api.CommonResult;
import com.edu.tutor.entity.User;
import com.edu.tutor.service.LoginService;
import com.edu.tutor.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController{
    @Autowired
    private MenuService menuService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user) {
        return loginService.login(user);
    }
}
