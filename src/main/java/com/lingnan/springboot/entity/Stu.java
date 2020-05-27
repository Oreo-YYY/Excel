package com.lingnan.springboot.entity;

import java.io.Serializable;

/**
 * (Stu)实体类
 *
 * @author makejava
 * @since 2020-05-27 21:40:10
 */
public class Stu implements Serializable {
    private static final long serialVersionUID = -10587116816245650L;
    
    private Integer no;
    
    private Integer id;
    
    private String name;
    
    private String className;
    
    private String remark;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}