package com.ssafy.plan.model.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlanResponseDto {
    private String planName;
    private List<PlanDetailDto> planDetailDtoList;

    public void addPlanDetail(PlanDetailDto planDetailDto) {
        planDetailDtoList.add(planDetailDto);
    }
}
