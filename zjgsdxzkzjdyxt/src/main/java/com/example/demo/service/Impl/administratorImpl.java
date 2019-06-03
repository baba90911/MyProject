package com.example.demo.service.Impl;

import com.example.demo.dao.*;
import com.example.demo.exception.MyException;
import com.example.demo.pojo.*;
import com.example.demo.pojo.result.cet4;
import com.example.demo.service.administratorService;
import net.bytebuddy.asm.Advice;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class administratorImpl implements administratorService {

    @Autowired
    StudentMapper  studentMapper;

    @Autowired
    Cet4Mapper cet4Mapper;

    @Autowired
    RuleMapper ruleMapper;

    @Autowired
    CategoriesMapper categoriesMapper;

    @Autowired
    Cet6Mapper cet6Mapper;


    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;

        List<Student> studentList=new ArrayList<>();

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        Student student;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null){
                continue;
            }
            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException

            student =new Student();
            if( row.getCell(0).getCellType()!=1){//循环时，得到每一行的单元格进行判断
                throw new MyException("导入失败(第"+(r+1)+"行,用户名请设为文本格式)");
            }
            String student_namber = row.getCell(0).getStringCellValue();//得到每一行第一个单元格的值
            if(student_namber == null || student_namber.isEmpty()){//判断是否为空
                throw new MyException("导入失败(第"+(r+1)+"行,用户名未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String grade = row.getCell(1).getStringCellValue();
            if(grade==null || grade.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,身份证未填写)");
            }

            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String IDnumber = row.getCell(1).getStringCellValue();
            if(IDnumber==null || IDnumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,身份证未填写)");
            }


            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String password = row.getCell(2).getStringCellValue();
            if(IDnumber==null || IDnumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,身份证未填写)");
            }

            //完整的循环一次 就组成了一个对象
            student.setStudentNumber(student_namber);
            student.setGrade(grade);
            student.setIdnumber(IDnumber);
            student.setPassword(password);
            studentList.add(student);
        }
        for (Student student1 : studentList) {
            String number=student1.getStudentNumber();
            int cnt=studentMapper.selectByNumber(number);
            if (cnt == 0) {
                studentMapper.insert(student1);
                System.out.println(" 插入 "+student1);
            } else {
                studentMapper.updateByPrimaryKey(student1);
                System.out.println(" 更新 "+student1);
            }
        }
        return notNull;


    }

    @Override
    public List<Categories> selectAllCategories() {
        return categoriesMapper.selectAll();
    }

    @Override
    public int updateRuleByCategory(Rule rule) {
        return ruleMapper.updateByPrimaryKey(rule);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.selectAll();
    }

    @Override
    public int updateStudent(Student student) {
        return  studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int deleteStudnetByGrade(String Grade) {
        return studentMapper.deleteOneGradeStudent(Grade);
    }

    @Override
    public boolean examImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull =false;
        List<Cet4> cet4List=new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        Cet4 cet4;
        for(int r=1;r<=sheet.getLastRowNum();r++){
            Row row=sheet.getRow(r);
            if(row==null){
                continue;
            }
            cet4 =new Cet4();
            if(row.getCell(0).getCellType()!=1){
                throw  new MyException("导入失败(第\"+(r+1)+\"行,用户名请设为文本格式)");
            }
            String studentNumber =row.getCell(0).getStringCellValue();
            if(studentNumber==null || studentNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学生学号未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String schoolName = row.getCell(1).getStringCellValue();
            if(schoolName==null || schoolName.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学校名字未填写)");
            }

            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String shoolCode = row.getCell(2).getStringCellValue();
            if(shoolCode==null || shoolCode.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学校编号未填写)");
            }

            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String roomNumber = row.getCell(3).getStringCellValue();
            if(roomNumber==null || roomNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考场编号未填写)");
            }

            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String seatNumber = row.getCell(4).getStringCellValue();
            if(seatNumber==null || seatNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,座位号未填写)");
            }

            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String studentName = row.getCell(5).getStringCellValue();
            if(studentName==null || studentName.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学生姓名未填写)");
            }

            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String className = row.getCell(6).getStringCellValue();
            if(className==null || className.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,班级名称未填写)");
            }

            row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String examNumber = row.getCell(7).getStringCellValue();
            if(examNumber==null || examNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,准考证号未填写)");
            }


            row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String classroom = row.getCell(8).getStringCellValue();
            if(classroom==null || classroom.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试教室未填写)");
            }

            row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String time = row.getCell(9).getStringCellValue();
            if(time==null || time.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试时间未填写)");
            }

            row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String quantum = row.getCell(10).getStringCellValue();
            if(quantum==null || quantum.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试时间具体范围未填写)");
            }

            row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String rule = row.getCell(11).getStringCellValue();
            if(rule==null || rule.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试规则未填写)");
            }

            cet4.setClassName(className);
            cet4.setClassroom(classroom);
            cet4.setExamNumber(examNumber);
            cet4.setQuantum(quantum);
            cet4.setRoomNumber(roomNumber);
            cet4.setRule(rule);
            cet4.setSchoolName(schoolName);
            cet4.setSeatNumber(seatNumber);
            cet4.setShoolCode(shoolCode);
            cet4.setStudentName(studentName);
            cet4.setStudentNumber(studentNumber);
            cet4.setTime(time);
            cet4List.add(cet4);

        }

        for(Cet4 cet41 :cet4List){
            String number =cet41.getStudentNumber();
            int cnt =cet4Mapper.selectByStudentNumber(number);
            if(cnt==0){
                cet4Mapper.insert(cet41);
                System.out.println("插入"+cet41);
            }else{
                cet4Mapper.updateByPrimaryKey(cet41);
                System.out.println("更新"+cet41);
            }
        }
        return notNull;
    }

    @Override
    public boolean cet6Import(String fileName, MultipartFile file) throws Exception {
        boolean notNull =false;
        List<Cet6> cet6List=new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        Cet6 cet6;
        for(int r=1;r<=sheet.getLastRowNum();r++){
            Row row=sheet.getRow(r);
            if(row==null){
                continue;
            }
            cet6 =new Cet6();
            if(row.getCell(0).getCellType()!=1){
                throw  new MyException("导入失败(第\"+(r+1)+\"行,用户名请设为文本格式)");
            }
            String studentNumber =row.getCell(0).getStringCellValue();
            if(studentNumber==null || studentNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学生学号未填写)");
            }

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String schoolName = row.getCell(1).getStringCellValue();
            if(schoolName==null || schoolName.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学校名字未填写)");
            }

            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String shoolCode = row.getCell(2).getStringCellValue();
            if(shoolCode==null || shoolCode.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学校编号未填写)");
            }

            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String roomNumber = row.getCell(3).getStringCellValue();
            if(roomNumber==null || roomNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考场编号未填写)");
            }

            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String seatNumber = row.getCell(4).getStringCellValue();
            if(seatNumber==null || seatNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,座位号未填写)");
            }

            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String studentName = row.getCell(5).getStringCellValue();
            if(studentName==null || studentName.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,学生姓名未填写)");
            }

            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String className = row.getCell(6).getStringCellValue();
            if(className==null || className.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,班级名称未填写)");
            }

            row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String examNumber = row.getCell(7).getStringCellValue();
            if(examNumber==null || examNumber.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,准考证号未填写)");
            }


            row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String classroom = row.getCell(8).getStringCellValue();
            if(classroom==null || classroom.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试教室未填写)");
            }

            row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String time = row.getCell(9).getStringCellValue();
            if(time==null || time.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试时间未填写)");
            }

            row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String quantum = row.getCell(10).getStringCellValue();
            if(quantum==null || quantum.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试时间具体范围未填写)");
            }

            row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String rule = row.getCell(11).getStringCellValue();
            if(rule==null || rule.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,考试规则未填写)");
            }

            cet6.setClassName(className);
            cet6.setClassroom(classroom);
            cet6.setExamNumber(examNumber);
            cet6.setQuantum(quantum);
            cet6.setRoomNumber(roomNumber);
            cet6.setRule(rule);
            cet6.setSchoolName(schoolName);
            cet6.setSeatNumber(seatNumber);
            cet6.setShoolCode(shoolCode);
            cet6.setStudentName(studentName);
            cet6.setStudentNumber(studentNumber);
            cet6.setTime(time);
            cet6List.add(cet6);

        }

        for(Cet6 cet61 :cet6List){
            String number =cet61.getStudentNumber();
            int cnt =cet6Mapper.selectByStudentNumber(number);
            if(cnt==0){
                cet6Mapper.insert(cet61);
                System.out.println("插入"+cet61);
            }else{
                cet6Mapper.updateByPrimaryKey(cet61);
                System.out.println("更新"+cet61);
            }
        }
        return notNull;
    }


}
