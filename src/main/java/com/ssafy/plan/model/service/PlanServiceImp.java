package com.ssafy.plan.model.service;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.attraction.model.mapper.AttractionMapper;
import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
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
            log.debug("PlanServiceImpl pDL size : " + planDetailDtoList.size());
            PlanResponseDto planResponseDto = PlanResponseDto.builder()
                    .planName(planDto.getPlanName())
                    .attractionImages(new String[planDetailDtoList.size()])
                    .attractionTitles(new String[planDetailDtoList.size()])
                    .build();
            System.out.println("pRD : " + planResponseDto);
            System.out.println(planDetailDtoList);
            for (PlanDetailDto planDetailDto : planDetailDtoList) {
//                planResponseDto.addPlanDetail(planDetailDto);
                int contentId = planDetailDto.getContentId();
                AttractionDto attractionDto = attractionMapper.findAttractionById(contentId);
                int idx = planDetailDto.getPlanOrder();
                planResponseDto.getAttractionImages()[idx-1] = attractionDto.getImage();
                planResponseDto.getAttractionTitles()[idx-1] = attractionDto.getTitle();
            }
            planResponseDtoList.add(planResponseDto);
        }
        log.debug("PlanServiceImpl pRDL : " + planResponseDtoList);
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
    public void addPlanAndDetails(String userId, List<Integer> contentIdList) {
        log.debug("addPlanAndDetails : " + userId + ", " + contentIdList);
        PlanDto planDto = PlanDto.builder()
                .userId(userId)
                .planName("프론트에서 플랜 네임 입력 필요")
                .build();
        addPlan(planDto);
        // Mybatis secretKey 사용해서 AutoIncrement PlanId 값 찾아옴
        int planId = planDto.getPlanId();

        List<PlanDetailDto> planDetailDtoList = new ArrayList<>();
        int idx = 1;
        for (Integer contentId : contentIdList) {
            PlanDetailDto planDetailDto = PlanDetailDto.builder()
                    .planOrder(idx++)
                    .descript("descript 처리 필요")
                    .contentId(contentId)
                    .planId(planId)
                    .build();
            planDetailDtoList.add(planDetailDto);
        }
        planMapper.addPlanDetails(planDetailDtoList);
    }
}
