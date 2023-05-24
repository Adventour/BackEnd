package com.ssafy.plan.model.service;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.dto.PlanRequestDto;
import com.ssafy.plan.model.dto.PlanResponseDto;

import java.util.List;

public interface PlanService {

    List<PlanResponseDto> findPlansByMemberDto(MemberDto memberDto) throws Exception;
    List<PlanDetailDto> findPlanDetailsByPlanDto(PlanDto planDto) throws Exception;

    void addPlan(PlanDto planDto);

    void addPlanDetails(List<PlanDetailDto> planDetailDtoList);

    void addPlanAndDetails(String userId, PlanRequestDto planRequestDto);

    void modifyPlanDetails(String userId, PlanRequestDto planRequestDto);

    void deletePlanDetails(String userId, int planId);
}
