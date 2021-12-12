package com.edu.tutor.controller;

import com.edu.tutor.core.api.CommonResult;
import com.edu.tutor.entity.Menu;
import com.edu.tutor.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/home")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/sousuo")
    public CommonResult getMenuList(){
        return CommonResult.success(menuService.getMenuList());
    }

    @PostMapping("/menuList")
    public CommonResult getMenuListFor(){
        return CommonResult.success(menuService.listMenu());
    }
}
