package com.edu.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.tutor.core.api.CommonResult;
import com.edu.tutor.dao.MenuMapper;
import com.edu.tutor.entity.Menu;
import com.edu.tutor.entity.User;
import com.edu.tutor.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Resource
    MenuMapper menuDao;

    @Override
    public List<Menu> getMenuList() {
        return super.baseMapper.selectList(null);
    }

    @Override
    public List menuList() {
        /*List<Menu> menuList = getMenuList();
        Collections.sort(menuList);
        Map<String, Map<String, Object>> menuMap = new HashMap<String, Map<String, Object>>();
        List<Map<String, Object>> mapList = menuList.stream().map(menu->{
            Map<String, Object> newMenu = new HashMap<>();
            if(menu.getLevel() == 1) {
                newMenu.put("text", menu.getText());
                newMenu.put("iconCls", menu.getIconCls());
                newMenu.put("level", 1);
            } else {
                Map<String, Object> parent = menuMap.get(menu.getParent());
                if(parent.get("children") == null) {
                    parent.put("children", new ArrayList());
                }
                newMenu.put("text", "<input type='hidden' value='" + menu.getAddress() + "'/>" + menu.getText());
                ((List<Map<String, Object>>) parent.get("children")).add(newMenu);
            }
            menuMap.put(menu.getId(), newMenu);

            return newMenu;
        }).filter(menu->{
            if(menu.get("level") != null) {
                menu.remove("level");
                return true;
            }
            return false;
        }).collect(Collectors.toList());*/

        return null;
    }
    public List<Menu> listMenu(){
        List<Menu> menus=this.getMenuList();
        List<Menu> menus1=menus.stream().filter(i->
            i.getParent() == 0
        ).map((menu -> {
            menu.setChild(getChildren(menu,menus));
            return menu;
        })).sorted((menu1,menu2)->{
            return (menu1.getSequence()==null?0:menu1.getSequence())-(menu2.getSequence()==null?0:menu2.getSequence());
        }).collect(Collectors.toList());
        return menus1;
    }

    @Override
    public List<Menu> listMenuByPage() {
        return null;
    }

    public List<Menu> getChildren(Menu root,List<Menu> all) {
        List<Menu> menu = all.stream().filter(i -> {
                return root.getId().equals(i.getParent());
        }).map(j -> {
            j.setChild(getChildren(j, all));
            return j;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSequence() == null ? 0 : menu1.getSequence()) - (menu2.getSequence() == null ? 0 : menu2.getSequence());
        }).collect(Collectors.toList());
        return menu;
    }
}
