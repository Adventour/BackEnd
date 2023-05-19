package com.ssafy.plan.model.dto;

import com.ssafy.attraction.model.dto.AttractionDto;
import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor
public class PlanDto {
	private int planId;
	private int userId;
	private String planName;

}
