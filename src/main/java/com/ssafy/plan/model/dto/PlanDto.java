package com.ssafy.plan.model.dto;

import com.ssafy.attraction.model.dto.AttractionDto;
import lombok.*;

@Data
@RequiredArgsConstructor
public class PlanDto {
	private int planId;
	private String userId;
	private String planName;

}
