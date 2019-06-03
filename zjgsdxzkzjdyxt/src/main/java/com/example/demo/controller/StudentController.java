package com.example.demo.controller;


import com.example.demo.pojo.Cet4;
import com.example.demo.pojo.JsonData;
import com.example.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/v1/api/students"})
@Api(description = "学生操作")
@CrossOrigin
public class StudentController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    StudentService studentService;

    @ApiOperation("查询4级准考证数据")
    @GetMapping("/student")
    public JsonData findCet4ByNumber(@RequestParam String  number) throws Exception{
        try{
            return JsonData.success(studentService.findCet4ByStudentNumberOrIDNumber(number));
        }catch (Exception e){
            this.logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }

    @ApiOperation("查询6级准考证数据")
    @GetMapping("/student1")
    public JsonData findCet6ByNumber(@RequestParam String  number) throws Exception{
        try{
            return JsonData.success(studentService.findCet6ByStudentNumberOrIDNumber(number));
        }catch (Exception e){
            this.logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }


}
