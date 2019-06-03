package com.example.demo.controller;
import com.example.demo.dao.PicturesMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.pojo.*;
import com.example.demo.service.administratorService;
import com.example.demo.util.ImageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@RestController
@RequestMapping({"/v1/api/admin"})
@Api(description = "管理员操作")
@CrossOrigin
public class AdministratorController {

    Logger logger=LoggerFactory.getLogger(getClass());



    @Autowired
    PicturesMapper picturesMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    administratorService administratorService;

    @ApiOperation("导入学生图片")
    @PostMapping(value = "/studentImages",consumes = "multipart/*")
    public void addImages(/*MultipartFile[] image  List<MultipartFile> image,*/ MultipartHttpServletRequest request,HttpServletResponse response)throws FileUploadBase.FileUploadIOException,IOException {
        MultiValueMap<String,MultipartFile>map =request.getMultiFileMap();
        List<MultipartFile> list =map.get("uploadify");
        for(MultipartFile pho1: list) {
            String picturename = pho1.getOriginalFilename();
            String studentnumber = picturename.substring(0, picturename.length() - 4);
            String folder = "img/";
            File imageFolder = new File(request.getServletContext().getRealPath(folder));
            File file = new File(imageFolder, picturename);
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
           // String path = file.getAbsolutePath();
            String path="Http://10.14.14.2:8080/"+picturename;
            pho1.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
            Pictures pictures = new Pictures();
            pictures.setPicture(path);
            pictures.setStudentNumber(studentnumber);
            picturesMapper.insert(pictures);
        }
        response.sendRedirect("10.");
    }

    @ApiOperation("导入学生数据")
    @PostMapping("/import_student")
    public Boolean StudentImport(@RequestParam(value = "filename")MultipartFile file, HttpSession session) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = administratorService.batchImport(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }



    @ApiOperation("导入4级准考证数据")
    @PostMapping({"import_cet4_exam"})
    public JsonData exImport(@RequestParam(value = "filename")MultipartFile file, HttpSession session){
        boolean a=false;
        String filename=file.getOriginalFilename();
        try{
            a=administratorService.examImport(filename,file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.success(a);
    }

    @ApiOperation("导入6级准考证数据")
    @PostMapping({"import_cet6_exam"})
    public JsonData cet6Import(@RequestParam(value = "filename")MultipartFile file, HttpSession session){
        boolean a=false;
        String filename=file.getOriginalFilename();
        try{
            a=administratorService.examImport(filename,file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.success(a);
    }


    @ApiOperation("导出学生数据模板")
    @GetMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        List<Student> students = studentMapper.selectAll();

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取excel测试表格");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("用户信息列表");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第3个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(rowRegion);

      /*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
      sheet.addMergedRegion(columnRegion);*/


        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("学号");//为第一个单元格设值
        row.createCell(1).setCellValue("年级");
        row.createCell(2).setCellValue("身份证号码");//为第二个单元格设值
        row.createCell(3).setCellValue("用户密码");//为第三个单元格设值

        for (int i = 0; i < students.size(); i++) {
            row = sheet.createRow(i + 2);
            Student student=students.get(i);
            row.createCell(0).setCellValue(student.getStudentNumber());
            row.createCell(1).setCellValue(student.getGrade());
            row.createCell(2).setCellValue(student.getIdnumber());
            row.createCell(3).setCellValue(student.getPassword());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=user.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }


    @ApiOperation("查询准考证类型")
    @GetMapping({"get_all_categories"})
    public JsonData getAllCategories(@RequestParam(value = "page_num", defaultValue = "1") int pageNum, @RequestParam(value = "record", defaultValue = "10") int record){
        try{
            Map<String,Object> result=new HashMap<>();
            PageHelper.startPage(pageNum,record);
            PageInfo<Categories> pageInfo=new PageInfo<>(administratorService.selectAllCategories());
            result.put("data", pageInfo.getList());
            result.put("page_num", Integer.valueOf(pageNum));
            result.put("pages", Integer.valueOf(pageInfo.getPages()));
            return JsonData.success(result);
        }catch (Exception e){
            this.logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }


    @ApiOperation("修改注意项")
    @PutMapping({"update_rule"})
    public JsonData updateRule(@RequestBody Rule rule){return JsonData.success(Integer.valueOf(this.administratorService.updateRuleByCategory(rule)));}



    @ApiOperation("获取所有学生信息")
    @GetMapping({"get_all_student"})
    public JsonData getAllStudent(@RequestParam(value = "page_num", defaultValue = "1") int pageNum, @RequestParam(value = "record", defaultValue = "10") int record){
        try{
            Map<String,Object> result=new HashMap<>();
            PageHelper.startPage(pageNum,record);
            PageInfo<Student> pageInfo=new PageInfo<>(administratorService.getAllStudent());
            result.put("data", pageInfo.getList());
            result.put("page_num", Integer.valueOf(pageNum));
            result.put("pages", Integer.valueOf(pageInfo.getPages()));
            return  JsonData.success(result);
        }catch (Exception e){
            this.logger.error(e.getMessage());
            return  JsonData.fail(e.getMessage());
        }

    }


    @ApiOperation("修改学生信息")
    @PutMapping({"update_student"})
    public  JsonData updateStudent(@RequestBody Student student){return JsonData.success(this.administratorService.updateStudent(student));}



    @ApiOperation("删除一个年纪学生")
    @PutMapping
    public JsonData deleteOneGradeStudent(@RequestParam String grade){return  JsonData.success(this.administratorService.deleteStudnetByGrade(grade));}



}
