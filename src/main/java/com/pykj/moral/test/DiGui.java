package com.pykj.moral.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.mysql.jdbc.StringUtils;

public class DiGui {

//	@Resource
//	private MenuDao menudao;
//	
//	public void testQueryMenuList() {
//		
//		// 原始的数据
//		List<Menu> rootMenu = menudao.queryMenuList();
//
//		// 查看结果
//		for (Menu menu : rootMenu) {
//			System.out.println(menu);
//		}
//		// 最后的结果
//		List<Menu> menuList = new ArrayList<Menu>();
//		// 先找到所有的一级菜单
//		for (int i = 0; i < rootMenu.size(); i++) {
//			// 一级菜单没有parentId
//			if (StringUtils.isBlank(rootMenu.get(i).getParentId())) {
//				//获得一级菜单;
//				menuList.add(rootMenu.get(i));
//			}
//		}
//		// 为一级菜单设置子菜单，getChild是递归调用的
//		for (Menu menu : menuList) {
//			menu.setChildMenus(getChild(menu.getId(), rootMenu));
//		}
//		Map<String, Object> jsonMap = new HashMap<>();
//		jsonMap.put("menu", menuList);
//		System.out.println(gson.toJson(jsonMap));
//
//	}
//
//	/**
//	 * 递归查找子菜单
//	 * 
//	 * @param id
//	 *            当前菜单id
//	 * @param rootMenu
//	 *            要查找的列表
//	 * @return
//	 */
//	private List<Menu> getChild(String id, List<Menu> rootMenu) {
//		// 子菜单
//		List<Menu> childList = new ArrayList<>();
//		for (Menu menu : rootMenu) {
//			// 遍历所有节点，将父菜单id与传过来的id比较
//			if (StringUtils.isNotBlank(menu.getParentId())) {
//				if (menu.getParentId().equals(id)) {
//					childList.add(menu);
//				}
//			}
//		}
//		
//		// 把子菜单的子菜单再循环一遍
//		for (Menu menu : childList) {// 没有url子菜单还有子菜单
//			if (StringUtils.isBlank(menu.getUrl())) {
//				// 递归
//				menu.setChildMenus(getChild(menu.getId(), rootMenu));
//			}
//			
//		} // 递归退出条件
//		if (childList.size() == 0) {
//			return null;
//		}
//		return childList;
//	}

}
