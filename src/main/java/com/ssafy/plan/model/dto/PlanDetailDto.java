package com.ssafy.plan.model.dto;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanDetailDto {

    private int planId;
    private int planOrder;
    private int contentId;

    // TODO
    //      descript가 필요한가?
    private String descript;

}
