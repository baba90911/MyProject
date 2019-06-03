package com.example.demo.mapper;

import java.util.List;

import com.example.demo.bean.Picture;

public interface PictureMapper {
	Picture findPictureByPaddress(String add) throws Exception;
	List<Picture>  findPictureByTname(String name)throws Exception;
}
