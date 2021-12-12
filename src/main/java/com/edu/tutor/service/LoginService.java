package com.edu.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.tutor.core.api.CommonResult;
import com.edu.tutor.entity.User;

public interface LoginService extends IService<User> {
    CommonResult login(User user);
}
