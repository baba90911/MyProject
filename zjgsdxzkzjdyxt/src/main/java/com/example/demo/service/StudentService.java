package com.example.demo.service;

import com.example.demo.pojo.Cet4;
import com.example.demo.pojo.result.cet4;
import com.example.demo.pojo.result.cet6;

public interface StudentService {
    public  boolean judgeTime(String category);
    public cet4 findCet4ByStudentNumberOrIDNumber(String number);
    public cet6 findCet6ByStudentNumberOrIDNumber(String number);
}
