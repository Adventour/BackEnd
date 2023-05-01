package com.ssafy.plan.model.dto;

import com.ssafy.attraction.model.dto.AttractionDto;

public class PlanDto {	
	private int planId;
	private int planOrder;
	private int userId;
	private String planName;
	private AttractionDto place;
	
	public PlanDto() {	}

	public PlanDto(int planId, int planOrder, int userId, String planName, AttractionDto place) {
		super();
		this.planId = planId;
		this.planOrder = planOrder;
		this.userId = userId;
		this.planName = planName;
		this.place = place;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getPlanOrder() {
		return planOrder;
	}

	public void setPlanOrder(int planOrder) {
		this.planOrder = planOrder;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public AttractionDto getPlace() {
		return place;
	}

	public void setPlace(AttractionDto place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "PlanDto [planId=" + planId + ", planOrder=" + planOrder + ", userId=" + userId + ", planName="
				+ planName + ", place=" + place + "]";
	}
}
