package com.example.demo.dao;

import com.example.demo.pojo.TotalityTicket;
import java.util.List;

public interface TotalityTicketMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table totality_ticket
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table totality_ticket
     *
     * @mbg.generated
     */
    int insert(TotalityTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table totality_ticket
     *
     * @mbg.generated
     */
    TotalityTicket selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table totality_ticket
     *
     * @mbg.generated
     */
    List<TotalityTicket> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table totality_ticket
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TotalityTicket record);
}