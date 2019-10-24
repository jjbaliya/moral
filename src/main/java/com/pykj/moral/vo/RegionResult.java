package com.pykj.moral.vo;

import com.pykj.moral.utils.ResultOut;

public class RegionResult extends ResultOut {

	private Integer total;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public RegionResult(Object rows) {
		super(rows);
		// TODO Auto-generated constructor stub
	}

	public RegionResult(Object rows , Integer total) {
		super(rows);
		this.total = total;
		// TODO Auto-generated constructor stub
	}
	
	//查询用;
	public static RegionResult ok(Object rows , Integer total) {
        return new RegionResult(rows , total);
    }

	//增删改用;
    public static RegionResult ok() {
        return new RegionResult(null);
    }
	
	
}
