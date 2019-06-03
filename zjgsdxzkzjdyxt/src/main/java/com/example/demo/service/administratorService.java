package com.example.demo.service;

import com.example.demo.pojo.Categories;
import com.example.demo.pojo.Rule;
import com.example.demo.pojo.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface administratorService {
    boolean batchImport(String fileName, MultipartFile file) throws Exception;

    List<Categories> selectAllCategories();

    int updateRuleByCategory(Rule rule);

    List<Student> getAllStudent();


    int updateStudent(Student student);

    int deleteStudnetByGrade(String Grade);


    boolean  examImport(String fileName,MultipartFile file)throws  Exception;

    boolean  cet6Import(String fileName,MultipartFile file)throws  Exception;

}
