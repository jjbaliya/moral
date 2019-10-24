package com.pykj.moral.service;

import java.util.List;

import com.pykj.moral.entity.Files;

public interface FilesService {

	void deleteByPrimaryKey(Integer id);

	void insert(Files record);

	void insertSelective(Files record);

	Files selectByPrimaryKey(Integer id);

	void updateByPrimaryKeySelective(Files record);

	void updateByPrimaryKey(Files record);
	
	List<Files> selectAll();
	
}
