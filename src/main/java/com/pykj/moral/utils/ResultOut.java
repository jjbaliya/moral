package com.pykj.moral.utils;

import java.util.List;


/**
 * 淘淘商城自定义响应结构
 */
public class ResultOut {

 
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object rows;

    public static ResultOut build(Integer status, String msg, Object rows) {
        return new ResultOut(status, msg, rows);
    }

    public static ResultOut ok(Object rows) {
        return new ResultOut(rows);
    }

    public static ResultOut ok() {
        return new ResultOut(null);
    }

    public ResultOut() {

    }

    public static ResultOut build(Integer status, String msg) {
        return new ResultOut(status, msg, null);
    }

    public ResultOut(Integer status, String msg, Object rows) {
    	//状态；
        this.status = status;
        //信息；
        this.msg = msg;
        
        this.rows = rows;
    }

    public ResultOut(Object rows) {
        this.status = 200;
        this.msg = "OK";
        this.rows = rows;
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getrows() {
        return rows;
    }

    public void setrows(Object rows) {
        this.rows = rows;
    }

	public static ResultOut nullError() {
		return new ResultOut(404, "没有取到数据", null);
		
	}

}


