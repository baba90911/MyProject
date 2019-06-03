package com.example.demo.service.Impl;

import com.example.demo.dao.AdministratorMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.pojo.Administrator;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    AdministratorMapper administratorMapper;



    @Override
    public boolean login(User user) {
        Boolean judge=false;
        if(user.getType()==0){
            Student student=studentMapper.selectByPrimaryKey(user.getUsername());
            if(student==null){
                judge=false;
            }else {
                if(student.getPassword().equals(user.getPassword())){
                    judge=true;
                }
                else{
                    judge=false;
                }
            }
        }else if(user.getType()==1){
            Administrator administrator=administratorMapper.selectByPrimaryKey(user.getUsername());
            if(administrator==null){
                judge=false;
            }else{
                if(administrator.getPassword().equals(user.getPassword())){
                    judge=true;
                }else{
                    judge=false;
                }
            }

        }
        return  judge;
    }
}
