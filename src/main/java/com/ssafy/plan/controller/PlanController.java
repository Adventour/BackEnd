package com.ssafy.plan.controller;

import java.util.List;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.dto.PlanResponseDto;
import com.ssafy.plan.model.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

	private final PlanService planService;

	@PostMapping("/")
	public ResponseEntity<?> addPlan(@RequestBody PlanDto planDto) {
		planService.addPlan(planDto);

		// TODO
		//		임시 테스트용으로 PlanDto 만 받아옴, planDetailDto 필요
		// 		planId AutoIncrement 변경 필요

		return new ResponseEntity<>(planDto, HttpStatus.OK);
	}

	@PostMapping("/test")
	public ResponseEntity<?> addPlanDetails(@RequestBody List<PlanDetailDto> planDetailDtoList) {
		planService.addPlanDetails(planDetailDtoList);

		return new ResponseEntity<>(planDetailDtoList, HttpStatus.OK);
	}


	// TODO
	// 		Authentication 처리해서 본인 것 받아오는 걸로
	@PostMapping("/search")
	public ResponseEntity<?> searchPlan(@RequestBody MemberDto memberDto) throws Exception {
		try {
			List<PlanResponseDto> planResponseDtoList = planService.findPlansByMemberDto(memberDto);
			return new ResponseEntity<>(planResponseDtoList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.OK);
		}

	}

	@GetMapping("/details")
	public ResponseEntity<?> searchPlanDetail(@RequestBody PlanDto planDto) throws Exception {
		List<PlanDetailDto> planDetailDtoList = planService.findPlanDetailsByPlanDto(planDto);
		return new ResponseEntity<>(planDetailDtoList, HttpStatus.OK);
	}
}
