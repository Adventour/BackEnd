package com.ssafy.plan.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.plan.model.dao.PlanDao;
import com.ssafy.plan.model.dao.PlanDaoImp;
@Service
public class PlanServiceImp implements PlanService{
	private static PlanService instance = new PlanServiceImp();
	private PlanDao planDao;
	
	private PlanServiceImp() {
		planDao = PlanDaoImp.getInstance();
	}

	public static PlanService getInstance() {
		return instance;
	}

}
