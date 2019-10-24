package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.pykj.moral.entity.Dormregion;

public class TestQueryMeumList {

	public void testQueryMenuList() {
		// 原始数据
		List<Dormregion> rootDormregion = new ArrayList<Dormregion>();
		// 查看结果
		for (Dormregion dormregion : rootDormregion) {
			System.out.println(dormregion.toString());
		}
		// 最后的结果
		List<Dormregion> menuList = new ArrayList<Dormregion>();
		// 先找到所有的一级菜单
		for (int i = 0; i < rootDormregion.size(); i++) {
			// 一级菜单没有parentId
			if (StringUtils.isEmpty(rootDormregion.get(i).getParentid())) {
				menuList.add(rootDormregion.get(i));
			}
		}
		// 为一级菜单设置子菜单，getChild是递归调用的
		for (Dormregion dr : menuList) {
			dr.setListdormregion(getChild(dr.getRegionid(), rootDormregion));
			// setChildMenus(getChild(menu.getId(), rootMenu));
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("menu", menuList);
		System.out.println(JSONArray.toJSON(jsonMap));

	}

	private List<Dormregion> getChild(Integer regionid, List<Dormregion> rootDormregion) {
		// 子菜单
		List<Dormregion> childList = new ArrayList<Dormregion>();
		for (Dormregion dr : rootDormregion) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (!StringUtils.isEmpty(dr.getParentid())) {
				if (dr.getParentid().equals(regionid)) {
					childList.add(dr);
				}
			}
		}
		// 把子菜单的子菜单再循环一遍
		for (Dormregion dr : childList) {// 没有url子菜单还有子菜单
			dr.setListdormregion(getChild(dr.getRegionid(), rootDormregion));
			// menu.setChildMenus(getChild(menu.getId(), rootMenu));

		} // 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}
}
