package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;

public class TotalityTicket implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.school_name
     *
     * @mbg.generated
     */
    private String schoolName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.shool_code
     *
     * @mbg.generated
     */
    private String shoolCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.room_number
     *
     * @mbg.generated
     */
    private Integer roomNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.seat_number
     *
     * @mbg.generated
     */
    private Integer seatNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.student_name
     *
     * @mbg.generated
     */
    private String studentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.class_name
     *
     * @mbg.generated
     */
    private String className;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.exam_number
     *
     * @mbg.generated
     */
    private String examNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.classroom
     *
     * @mbg.generated
     */
    private String classroom;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.time
     *
     * @mbg.generated
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.quantum
     *
     * @mbg.generated
     */
    private String quantum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column totality_ticket.rule
     *
     * @mbg.generated
     */
    private String rule;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table totality_ticket
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.id
     *
     * @return the value of totality_ticket.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.id
     *
     * @param id the value for totality_ticket.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.school_name
     *
     * @return the value of totality_ticket.school_name
     *
     * @mbg.generated
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.school_name
     *
     * @param schoolName the value for totality_ticket.school_name
     *
     * @mbg.generated
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.shool_code
     *
     * @return the value of totality_ticket.shool_code
     *
     * @mbg.generated
     */
    public String getShoolCode() {
        return shoolCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.shool_code
     *
     * @param shoolCode the value for totality_ticket.shool_code
     *
     * @mbg.generated
     */
    public void setShoolCode(String shoolCode) {
        this.shoolCode = shoolCode == null ? null : shoolCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.room_number
     *
     * @return the value of totality_ticket.room_number
     *
     * @mbg.generated
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.room_number
     *
     * @param roomNumber the value for totality_ticket.room_number
     *
     * @mbg.generated
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.seat_number
     *
     * @return the value of totality_ticket.seat_number
     *
     * @mbg.generated
     */
    public Integer getSeatNumber() {
        return seatNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.seat_number
     *
     * @param seatNumber the value for totality_ticket.seat_number
     *
     * @mbg.generated
     */
    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.student_name
     *
     * @return the value of totality_ticket.student_name
     *
     * @mbg.generated
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.student_name
     *
     * @param studentName the value for totality_ticket.student_name
     *
     * @mbg.generated
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.class_name
     *
     * @return the value of totality_ticket.class_name
     *
     * @mbg.generated
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.class_name
     *
     * @param className the value for totality_ticket.class_name
     *
     * @mbg.generated
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.exam_number
     *
     * @return the value of totality_ticket.exam_number
     *
     * @mbg.generated
     */
    public String getExamNumber() {
        return examNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.exam_number
     *
     * @param examNumber the value for totality_ticket.exam_number
     *
     * @mbg.generated
     */
    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber == null ? null : examNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.classroom
     *
     * @return the value of totality_ticket.classroom
     *
     * @mbg.generated
     */
    public String getClassroom() {
        return classroom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.classroom
     *
     * @param classroom the value for totality_ticket.classroom
     *
     * @mbg.generated
     */
    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.time
     *
     * @return the value of totality_ticket.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.time
     *
     * @param time the value for totality_ticket.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.quantum
     *
     * @return the value of totality_ticket.quantum
     *
     * @mbg.generated
     */
    public String getQuantum() {
        return quantum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.quantum
     *
     * @param quantum the value for totality_ticket.quantum
     *
     * @mbg.generated
     */
    public void setQuantum(String quantum) {
        this.quantum = quantum == null ? null : quantum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column totality_ticket.rule
     *
     * @return the value of totality_ticket.rule
     *
     * @mbg.generated
     */
    public String getRule() {
        return rule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column totality_ticket.rule
     *
     * @param rule the value for totality_ticket.rule
     *
     * @mbg.generated
     */
    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table totality_ticket
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", shoolCode=").append(shoolCode);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", seatNumber=").append(seatNumber);
        sb.append(", studentName=").append(studentName);
        sb.append(", className=").append(className);
        sb.append(", examNumber=").append(examNumber);
        sb.append(", classroom=").append(classroom);
        sb.append(", time=").append(time);
        sb.append(", quantum=").append(quantum);
        sb.append(", rule=").append(rule);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}