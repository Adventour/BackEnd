package com.ssafy.plan.model.dao;

import com.ssafy.util.DBUtil;

public class PlanDaoImp implements PlanDao{
	private static PlanDao instance;
	private DBUtil util;
	
	public PlanDaoImp() {
		util = DBUtil.getInstance();
	}

	public static PlanDao getInstance() {
		return instance;
	}
	
	
}
