package com.pykj.moral.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pykj.moral.entity.Dormregion;
import com.pykj.moral.entity.User;
import com.pykj.moral.service.DormregionService;
import com.pykj.moral.utils.ResultOut;
import com.pykj.moral.vo.RegionResult;
/***
 * 官网△
 * 
 * 注解（文档）---demo
 * 1、前端传参方式【总结demo】
 * 2、后台回显方式【总结demo】
 * 3、上传（没封装）【封装demo】
 * 4、下载【原理：流】（做的不咋滴）（了解）
 * 5、全局的东西，了解可以了，关心本身涉及的东西
 * @author wgf
 *
 */

@Controller
@RequestMapping("/dormregion")
public class DormregionController implements BaseController<Dormregion>{
	
	@Resource
	DormregionService<Dormregion> dormregionService;
	
	@Resource
	DormregionService<List<Dormregion>> listdormregionService;
	
	@RequestMapping("/toview")
	public ModelAndView toView(){
		
		return new ModelAndView("/login");
		
	}
	//////////////////////////////
	@RequestMapping("/del")//url .../del/id
	public ResultOut test1(/*@PathVariable("/id") */) {
		return ResultOut.ok();
	}
	@RequestMapping("/test")
	public ResultOut test2(User user) {
		return ResultOut.ok();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ResultOut deleteByPrimaryKey(Integer regionid) {
		dormregionService.deleteByPrimaryKey(regionid);
		return ResultOut.ok();
	}

	@RequestMapping("/insert")
	@ResponseBody
	public ResultOut insertSelective(Dormregion t) {
		dormregionService.insertSelective(t);
		return ResultOut.ok();
	}

	@RequestMapping("/select")
	@ResponseBody
	public ResultOut selectByPrimaryKey(Integer regionid) {
		ResultOut ok = null ;
		Dormregion dorm = dormregionService.selectByPrimaryKey(regionid);
		if(dorm != null){
			ok = ResultOut.ok(dorm);
		}else{
			ok = ResultOut.nullError();
		}
		return ok;
	}

	@RequestMapping("/update")
	@ResponseBody
	public ResultOut updateByPrimaryKeySelective(Dormregion t) {
		dormregionService.updateByPrimaryKeySelective(t);
		return ResultOut.ok();
	}
	
	@RequestMapping("/selectall")
	@ResponseBody
	public RegionResult selectAll() {
		RegionResult ok = null;
		List<Dormregion> dorm = dormregionService.selectAll();
		if(dorm !=null && !dorm.isEmpty()){
			int dormSize= dorm.size();
			ok = RegionResult.ok(dorm, dormSize);
		}else{
			ok = RegionResult.ok();
		}
		return ok;
	}
	
	@RequestMapping("/backJosnp")
	public void backJosnp(HttpServletRequest request,HttpServletResponse response){
		try {  
	        response.setContentType("text/plain");  
	        response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0); 
	        response.setCharacterEncoding("utf-8");
	        
	        String callback = request.getParameter("callback");//客户端请求参数  
	        List<Dormregion> dorm = dormregionService.selectAll();  
	        
	        PrintWriter out = response.getWriter();    
	        JSONObject jo= new JSONObject();
	        jo.put("data", dorm);
 	        //Object object = JSONArray.toJSON(dorm);
	        //out.println(callback + "("+ object.toString() +")");//返回jsonp格式数据  
	        out.println(callback + "("+ jo.toString() +")");
	        
	        out.flush();  
	        out.close();  
	      } catch (IOException e) {  
	       e.printStackTrace();  
	      }  
	}
	
	@RequestMapping("/insertMul")
	@ResponseBody
	public ResultOut insertMul(Dormregion dormregion){
		
		System.out.println(JSONArray.toJSON(dormregion) + "-" + dormregion.getListdormregion().size() + "-" + dormregion.getListdormregion());
		
		if(!dormregion.getListdormregion().isEmpty() && dormregion.getListdormregion() != null){
			listdormregionService.insertMul(dormregion.getListdormregion());
		}
		return ResultOut.ok();
	}
	
	@RequestMapping("/batchDelete")
	@ResponseBody
	public ResultOut batchDeleteRegion(){
		List<Integer> listNum = new ArrayList<Integer>();
		listNum.add(48);
		listNum.add(49);
		listNum.add(50);
		System.out.println(listNum);
		dormregionService.batchDeleteRegion(listNum);
		return ResultOut.ok();
	}
	
	/**
	 * 按条件查询
	 * @param dormregion
	 * @return
	 */
	@RequestMapping("/selectMult")
	@ResponseBody
	public ResultOut selectRegionByMultCondition(Dormregion dormregion){
		List<Dormregion> listdormregion = dormregionService.selectRegionByMultCondition(dormregion);
		return ResultOut.ok(listdormregion);
		
	}
	
	@RequestMapping("/totable")
	public ModelAndView totable(){
		
		return new ModelAndView("/dormtable");
		
	}
	
}
