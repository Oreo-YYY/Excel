package com.lingnan.springboot.service.impl;

import com.lingnan.springboot.entity.Stu;
import com.lingnan.springboot.dao.StuDao;
import com.lingnan.springboot.service.StuService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * (Stu)表服务实现类
 *
 * @author makejava
 * @since 2020-05-27 21:40:13
 */
@Service("stuService")
public class StuServiceImpl implements StuService {

    @Resource
    private StuDao stuDao;

    @Override
    public int add(MultipartFile file) throws IOException {
        int result = 0;
        List<Stu> studentList = new ArrayList<>();
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        InputStream ins = file.getInputStream();
        Workbook wb = null;
        if (suffix.equals("xlsx")) {
            wb = new XSSFWorkbook(ins);
        } else {
            wb = new HSSFWorkbook(ins);
        }
        Sheet sheet = wb.getSheetAt(0);//获取工作表
        if (sheet != null) {
            for (int line = 2; line <= sheet.getLastRowNum(); line++) {//遍历工作表
                Stu student = new Stu();
                Row row = sheet.getRow(line);
                if (row == null) {//空行跳过
                    continue;
                }
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);//第一行
                String id = row.getCell(0).getStringCellValue();
                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//第二行
                String Stuid = row.getCell(1).getStringCellValue();
                String name = row.getCell(2).getStringCellValue();
                String className = row.getCell(3).getStringCellValue();
                String note = row.getCell(4).getStringCellValue();
                student.setId(Integer.parseInt(id));
                student.setId(Integer.parseInt(Stuid));
                student.setName(name);
                student.setClassName(className);
                student.setRemark(note);
                studentList.add(student);
            }
            for (Stu stuInfo : studentList) {
                result = stuDao.add(stuInfo);
            }

        }
        return result;
    }
}