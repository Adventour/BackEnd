package com.ssafy.plan.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PlanDetailDto {

    private int planId;
    private int planOrder;
    private int contentId;
    private String descript;

}
