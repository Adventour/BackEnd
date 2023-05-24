package com.ssafy.plan.model.service;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;
import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.dto.PlanRequestDto;
import com.ssafy.plan.model.dto.PlanResponseDto;
import com.ssafy.plan.model.mapper.PlanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PlanServiceImp implements PlanService{

    private final PlanMapper planMapper;
    private final AttractionMapper attractionMapper;

    @Override
    public List<PlanResponseDto> findPlansByMemberDto(MemberDto memberDto) throws Exception {
        List<PlanResponseDto> planResponseDtoList = new ArrayList<>();
        List<PlanDto> planDtoList = planMapper.findPlansByMemberDto(memberDto);
        for (PlanDto planDto : planDtoList) {
            List<PlanDetailDto> planDetailDtoList = planMapper.findPlanDetailsByPlanDto(planDto);
            PlanResponseDto planResponseDto = PlanResponseDto.builder()
                    .planId(planDto.getPlanId())
                    .planName(planDto.getPlanName())
                    .attractionImages(new String[planDetailDtoList.size()])
                    .attractionTitles(new String[planDetailDtoList.size()])
                    .descripts(new String[planDetailDtoList.size()])
                    .contentIds(new int[planDetailDtoList.size()])
                    .build();
            for (PlanDetailDto planDetailDto : planDetailDtoList) {
                int contentId = planDetailDto.getContentId();
                AttractionDto attractionDto = attractionMapper.findAttractionById(contentId);
                int idx = planDetailDto.getPlanOrder();
                planResponseDto.getAttractionImages()[idx-1] = attractionDto.getImage();
                planResponseDto.getAttractionTitles()[idx-1] = attractionDto.getTitle();
                planResponseDto.getContentIds()[idx-1] = attractionDto.getContentId();
                planResponseDto.getDescripts()[idx-1] = attractionMapper.getOverview(String.valueOf(contentId));
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

    @Override
    public void addPlanAndDetails(String userId, PlanRequestDto planRequestDto) {
        log.debug("addPlanAndDetails : " + userId + ", " + planRequestDto);
        PlanDto planDto = PlanDto.builder()
                .userId(userId)
                .planName(planRequestDto.getPlanName())
                .build();
        addPlan(planDto);
        // Mybatis secretKey 사용해서 AutoIncrement PlanId 값 찾아옴
        int planId = planDto.getPlanId();

        List<PlanDetailDto> planDetailDtoList = new ArrayList<>();
        int idx = 1;
        for (Integer contentId : planRequestDto.getContentIds()) {
            PlanDetailDto planDetailDto = PlanDetailDto.builder()
                    .planOrder(idx++)
//                    .descript("descript 처리 필요")
                    .contentId(contentId)
                    .planId(planId)
                    .build();
            planDetailDtoList.add(planDetailDto);
        }
        planMapper.addPlanDetails(planDetailDtoList);
    }

    @Override
    public void modifyPlanDetails(String userId, PlanRequestDto planRequestDto) {
        List<PlanDetailDto> planDetailDtoList = new ArrayList<>();
        int idx = 1;
        int planId = planRequestDto.getPlanId();
        for (Integer contentId : planRequestDto.getContentIds()) {
            PlanDetailDto planDetailDto = PlanDetailDto.builder()
                    .planOrder(idx++)
                    .descript("descript 처리 필요")
                    .contentId(contentId)
                    .planId(planId)
                    .build();
            planDetailDtoList.add(planDetailDto);
        }
        planMapper.deletePlanDetails(planRequestDto.getPlanId());
        planMapper.addPlanDetails(planDetailDtoList);
//        planMapper.addPlanDetails();

    }

    @Override
    public void deletePlanDetails(String userId, int planId) {
        PlanDto planDto = planMapper.findPlanByPlanId(planId);
        if (userId.equals(planDto.getUserId())) {
            planMapper.deletePlanDetails(planId);
            planMapper.deletePlan(planId);
        }
        else {
            // 올바르지 않은 접근
            log.debug("PlanServiceImpl : 올바르지 않은 접근입니다.");
        }

        // TODO
        //  userId, plan.userId 비교
        //  plan, planDetail 삭제 필요
    }
}
