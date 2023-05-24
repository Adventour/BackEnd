package com.ssafy.plan.model.dto;

import lombok.*;

import java.util.List;

/** 여행 세부 계획 보내주기 위한 DTO
 * */
@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlanResponseDto {
    private int planId;
    private String planName;
    private String[] attractionImages;
    private String[] attractionTitles;
    private int[] contentIds;
    private String[] descripts;

//    public void addPlanDetail(PlanDetailDto planDetailDto) {
//        planDetailDtoList.add(planDetailDto);
//    }

}
