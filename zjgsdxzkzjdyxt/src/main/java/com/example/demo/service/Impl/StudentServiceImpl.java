package com.example.demo.service.Impl;

import com.example.demo.dao.Cet4Mapper;
import com.example.demo.dao.Cet6Mapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.TimeMapper;
import com.example.demo.pojo.Cet4;
import com.example.demo.pojo.Cet6;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Time;
import com.example.demo.pojo.result.cet4;
import com.example.demo.pojo.result.cet6;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    Cet4Mapper cet4Mapper;

    @Autowired
    TimeMapper timeMapper;

    @Autowired
    Cet6Mapper cet6Mapper;

    @Override
    public boolean judgeTime(String category) {
        Time time=timeMapper.selectByPrimaryKey(category);
        Date date1=time.getTime();
        Date date2=new Date();
        if(date1.getTime()>date2.getTime()){
            return true;
        }else return false;
    }


    @Override
    public cet4 findCet4ByStudentNumberOrIDNumber(String number) {
        Student std1;
        std1=studentMapper.findstudentByNumberorIDNumber(number);
        return cet4Mapper.selectByPrimaryKey(std1.getStudentNumber());
    }

    @Override
    public cet6 findCet6ByStudentNumberOrIDNumber(String number) {
        Student std1;
        std1=studentMapper.findstudentByNumberorIDNumber(number);
        return cet6Mapper.selectByPrimaryKey(std1.getStudentNumber());
    }
}
