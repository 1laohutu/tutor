package com.edu.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.tutor.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<Menu> getMenuList();

    /**显示的菜单数据**/
    List menuList();
    List<Menu> listMenu();
    List<Menu> listMenuByPage();
}
