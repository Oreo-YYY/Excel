package com.lingnan.springboot.controller;

import com.lingnan.springboot.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("Stu")
public class StuController {

    @Resource
    private StuService stuService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @PostMapping("import")
    @ResponseBody
    public String excelImport(@RequestParam(value="filename")MultipartFile file, HttpSession session){
        String fileName = file.getOriginalFilename();
        int result = 0;
        try{
           result = stuService.add(file);
        }catch (Exception e ){
            e.printStackTrace();
        }
        if (result > 0 ){
            return "success!";
        }else{
            return "fail!";
        }
    }

}
