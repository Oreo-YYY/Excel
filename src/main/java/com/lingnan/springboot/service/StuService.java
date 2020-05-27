package com.lingnan.springboot.service;

import com.lingnan.springboot.entity.Stu;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * (Stu)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 21:40:13
 */
public interface StuService {


    int add(MultipartFile file) throws Exception;



}