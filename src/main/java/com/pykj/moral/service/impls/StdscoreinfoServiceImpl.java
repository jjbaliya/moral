package com.pykj.moral.service.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pykj.moral.dao.StdscoreinfoMapper;
import com.pykj.moral.entity.Stdscoreinfo;
import com.pykj.moral.service.StdscoreinfoService;

@Service("stdscoreinfoService")
public class StdscoreinfoServiceImpl<T> implements StdscoreinfoService<T> {
	
	@Resource
	StdscoreinfoMapper<T> stdscoreinfoDao;
	
	
	public void deleteByPrimaryKey(Integer uid) {
		stdscoreinfoDao.deleteByPrimaryKey(uid);
		
	}

	
	public void insert(T t) {
		stdscoreinfoDao.insert(t);
		
	}

	
	public void insertSelective(Stdscoreinfo t) {
		stdscoreinfoDao.insertSelective(t);
		
	}

	
	public T selectByPrimaryKey(Integer uid) {
		T t = stdscoreinfoDao.selectByPrimaryKey(uid);
		return t;
	}

	
	public void updateByPrimaryKeySelective(T t) {
		stdscoreinfoDao.updateByPrimaryKeySelective(t);
		
	}

	
	public void updateByPrimaryKey(T t) {
		stdscoreinfoDao.updateByPrimaryKey(t);
		
	}

	
	public List<Stdscoreinfo> selectAll() {
		List<Stdscoreinfo> liststdscoreinfo = stdscoreinfoDao.selectAll();
		return liststdscoreinfo;
	}

}
