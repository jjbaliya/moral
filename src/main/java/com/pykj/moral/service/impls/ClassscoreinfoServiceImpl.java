package com.pykj.moral.service.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pykj.moral.dao.ClassscoreinfoMapper;
import com.pykj.moral.entity.Classscoreinfo;
import com.pykj.moral.entity.Stdscoreinfo;
import com.pykj.moral.service.ClassscoreinfoService;

@Service("classscoreinfoService")
public class ClassscoreinfoServiceImpl<T> implements ClassscoreinfoService<T> {

	@Resource
	ClassscoreinfoMapper<T> classscoreinDao;
	
	public void deleteByPrimaryKey(Integer uid) {
		classscoreinDao.deleteByPrimaryKey(uid);

	}

	public void insert(T t) {
		classscoreinDao.insert(t);

	}

	public void insertSelective(Classscoreinfo t) {
		classscoreinDao.insertSelective(t);

	}

	@SuppressWarnings("unchecked")
	public T selectByPrimaryKey(Integer uid) {
		Classscoreinfo cc = classscoreinDao.selectByPrimaryKey(uid);
		return (T) cc;
	}

	public void updateByPrimaryKeySelective(T t) {
		classscoreinDao.updateByPrimaryKeySelective(t);

	}

	public void updateByPrimaryKey(T t) {
		classscoreinDao.updateByPrimaryKey(t);

	}

	public List<Classscoreinfo> selectAll() {
		List<Classscoreinfo> listclassscoreinfo = classscoreinDao.selectAll();
		return listclassscoreinfo;
	}

}
