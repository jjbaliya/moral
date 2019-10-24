package com.pykj.moral.service.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pykj.moral.dao.FilesMapper;
import com.pykj.moral.entity.Files;
import com.pykj.moral.service.FilesService;

@Service("filesServiceImp")
public class FilesServiceImpl implements FilesService {

	@Resource
	FilesMapper filesDao;
	
	
	public void deleteByPrimaryKey(Integer id) {
		filesDao.deleteByPrimaryKey(id);

	}

	
	public void insert(Files record) {
		filesDao.insert(record);

	}

	
	public void insertSelective(Files record) {
		filesDao.insertSelective(record);

	}

	
	public Files selectByPrimaryKey(Integer id) {
		return filesDao.selectByPrimaryKey(id);
	}

	
	public void updateByPrimaryKeySelective(Files record) {
		filesDao.updateByPrimaryKeySelective(record);

	}

	
	public void updateByPrimaryKey(Files record) {
		filesDao.updateByPrimaryKey(record);

	}

	
	public List<Files> selectAll() {
		return filesDao.getALLRecord();
	}

}
