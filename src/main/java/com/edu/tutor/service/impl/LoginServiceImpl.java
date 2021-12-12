package com.edu.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.tutor.core.api.CommonResult;
import com.edu.tutor.dao.UserMapper;
import com.edu.tutor.entity.User;
import com.edu.tutor.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService{
    @Override
    public CommonResult login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername())
                .eq(User::getPassword,user.getPassword());
        User user1=super.getOne(lambdaQueryWrapper);
        if (user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword())){
            return CommonResult.success(user1.getUsername());
        }
        else
            return CommonResult.validateFailed();
    }
}
