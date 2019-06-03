package com.example.demo.dao;

import com.example.demo.pojo.Cet4;
import com.example.demo.pojo.result.cet4;

import java.util.List;

public interface Cet4Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cet4
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String studentNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cet4
     *
     * @mbg.generated
     */
    int insert(Cet4 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cet4
     *
     * @mbg.generated
     */
    cet4 selectByPrimaryKey(String studentNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cet4
     *
     * @mbg.generated
     */
    List<Cet4> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cet4
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Cet4 record);


    int selectByStudentNumber(String number);
}