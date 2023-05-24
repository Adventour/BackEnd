package com.ssafy.plan.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@AllArgsConstructor
@ToString
@Getter
public class PlanRequestDto {
    private int planId;
    private String planName;
    private List<Integer> contentIds;
}
