package com.lingnan.springboot.dao;

import com.lingnan.springboot.entity.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Stu)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 21:40:12
 */

@Mapper
@Repository
public interface StuDao {


    /**
     * 新增数据
     *
     * @param stu 实例对象
     * @return 影响行数
     */
    int add(Stu stu);


}