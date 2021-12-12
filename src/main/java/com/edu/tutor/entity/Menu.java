package com.edu.tutor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Comparable<Menu>{
    private Integer id;

    private String name;

    private Integer level;

    private Integer parent;

    private Integer sequence;

    private String address;	//url地址

    private String platform;

    private String icon;

    @TableField(exist = false)
    private List<Menu> child;
    /**
     * 按照菜单层级和上级菜单顺序、本级菜单顺序的方式排列
     */
    @Override
    public int compareTo(Menu o) {
        int result = 0;
        if((result = this.level.compareTo(o.level)) != 0){
            return result;
        }
        if(this.parent!=null && o.parent!=null
                && (result = this.parent.compareTo(o.parent)) != 0) {
            return result;
        }
        if((result = this.sequence.compareTo(o.sequence)) != 0) {
            return result;
        }


        return this.id.compareTo(o.id);
    }
}
