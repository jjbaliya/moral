package com.pykj.moral.service.impls;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pykj.moral.dao.DormregionMapper;
import com.pykj.moral.entity.Dormregion;
import com.pykj.moral.service.DormregionService;
import com.pykj.moral.utils.JedisClient;
import com.pykj.moral.utils.JsonUtils;

@Service("dormregionService")
public class DormregionServiceImpl<T> implements DormregionService<T> {

	@Resource
	private DormregionMapper<T> dormregionDao;

	@Resource
	private JedisClient jedisclient;

	public void deleteByPrimaryKey(Integer regionid) {
		dormregionDao.deleteByPrimaryKey(regionid);
	}

	public void insert(T t) {
		dormregionDao.insert(t);
	}

	public void insertSelective(T t) {
		dormregionDao.insertSelective(t);
	}

	public T selectByPrimaryKey(Integer regionid) {

		Dormregion dr = dormregionDao.selectByPrimaryKey(regionid);

		return (T) dr;
	}

	public void updateByPrimaryKeySelective(T t) {
		dormregionDao.updateByPrimaryKeySelective(t);
	}

	public void updateByPrimaryKey(T t) {
		dormregionDao.updateByPrimaryKey(t);
	}

	public List<Dormregion> selectAll() {
		try {
			// 去缓存中取数据;
			String result = jedisclient.hget("dormregion", 1 + "");
			if (result != null) {
				// 字符串转换为list
				List<Dormregion> listdormregion = JsonUtils.jsonToList(result, Dormregion.class);
				return listdormregion;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//去数据库中取值;
		List<Dormregion> listdormregion = dormregionDao._list();
		try {
			// 向缓存中添加内容;
			String caString = JsonUtils.objectToJson(listdormregion);
			System.out.println(caString);
			jedisclient.hset("dormregion", 1 + "", caString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listdormregion;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertMul(List<Dormregion> listdormregion) {

		List<Integer> listNum = new ArrayList<Integer>();

		for (Dormregion dr : listdormregion) {
			dormregionDao.insertSelective((T) dr);
			int regionid = dr.getRegionid();
			listNum.add(regionid);
			System.out.println(listNum);
		}

	}

	public void batchDeleteRegion(List<Integer> regionid) {
		dormregionDao.batchDeleteRegion(regionid);

	}
	
	public List<Dormregion> selectRegionByMultCondition(Dormregion dormregion) {

		List<Dormregion> listdormregion = dormregionDao.selectRegionByMultCondition(dormregion);

		return listdormregion;
	}

}
