package com.ssafy.plan.model.service;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.mapper.PlanMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class PlanServiceImp implements PlanService{

    private PlanMapper planMapper;

    @Override
    public List<PlanDto> findPlansByUserId(MemberDto memberDto) throws Exception {
        return planMapper.findPlansByUserId(memberDto);
    }

    @Override
    public List<PlanDetailDto> findPlanDetailsByPlanId(PlanDto planDto) throws Exception {
        return planMapper.findPlanDetailsByPlanId(planDto);
    }
}
