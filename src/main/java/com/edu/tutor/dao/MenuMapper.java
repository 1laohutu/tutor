package com.edu.tutor.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.tutor.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> menuList();
}
