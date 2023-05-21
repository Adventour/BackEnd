package com.ssafy.plan.model.service;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.dto.PlanResponseDto;
import com.ssafy.plan.model.mapper.PlanMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class PlanServiceImp implements PlanService{

    private PlanMapper planMapper;

    @Override
    public List<PlanResponseDto> findPlansByMemberDto(MemberDto memberDto) throws Exception {
        List<PlanResponseDto> planResponseDtoList = new ArrayList<>();
        List<PlanDto> planDtoList = planMapper.findPlansByMemberDto(memberDto);
        System.out.println(planDtoList);
        for (PlanDto planDto : planDtoList) {
            System.out.println(planDto);
            PlanResponseDto planResponseDto = PlanResponseDto.builder()
                    .planName(planDto.getPlanName())
                    .planDetailDtoList(new ArrayList<>())
                    .build();
            System.out.println("pRD : " + planResponseDto);
            List<PlanDetailDto> planDetailDtoList = planMapper.findPlanDetailsByPlanDto(planDto);
            System.out.println(planDetailDtoList);
            for (PlanDetailDto planDetailDto : planDetailDtoList) {
                planResponseDto.addPlanDetail(planDetailDto);
            }
            planResponseDtoList.add(planResponseDto);
        }
        return planResponseDtoList;
    }

    @Override
    public List<PlanDetailDto> findPlanDetailsByPlanDto(PlanDto planDto) throws Exception {
        return planMapper.findPlanDetailsByPlanDto(planDto);
    }

    @Override
    public void addPlan(PlanDto planDto) {
        planMapper.addPlan(planDto);
    }

    @Override
    public void addPlanDetails(List<PlanDetailDto> planDetailDtoList) {
        planMapper.addPlanDetails(planDetailDtoList);
    }
}
