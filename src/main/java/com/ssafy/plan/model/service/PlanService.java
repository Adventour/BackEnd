package com.ssafy.plan.model.service;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;

import java.util.List;

public interface PlanService {

    List<PlanDto> findPlansByUserId(MemberDto memberDto) throws Exception;
    List<PlanDetailDto> findPlanDetailsByPlanId(PlanDto planDto) throws Exception;

    void addPlan(PlanDto planDto);

    void addPlanDetails(List<PlanDetailDto> planDetailDtoList);
}
