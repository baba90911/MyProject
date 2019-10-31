package com.example.demo.pojo;

import java.io.Serializable;

public class Pictures implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pictures.student_number
     *
     * @mbg.generated
     */
    private String studentNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pictures.picture
     *
     * @mbg.generated
     */
    private String picture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pictures
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pictures.student_number
     *
     * @return the value of pictures.student_number
     *
     * @mbg.generated
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pictures.student_number
     *
     * @param studentNumber the value for pictures.student_number
     *
     * @mbg.generated
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pictures.picture
     *
     * @return the value of pictures.picture
     *
     * @mbg.generated
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pictures.picture
     *
     * @param picture the value for pictures.picture
     *
     * @mbg.generated
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pictures
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentNumber=").append(studentNumber);
        sb.append(", picture=").append(picture);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}