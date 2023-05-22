package com.ssafy.plan.controller;

import java.util.List;
import java.util.Set;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.dto.PlanResponseDto;
import com.ssafy.plan.model.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

	private final PlanService planService;
	private final MemberService memberService;

	@PostMapping("/add")
	public ResponseEntity<?> addPlan(Authentication auth, @RequestBody List<Integer> contentIdList) {
		planService.addPlanAndDetails(auth.getName(), contentIdList);

		// TODO
		//		PlanResponseDto 보내주던지 하기
		return new ResponseEntity<>("성공", HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchPlan(Authentication auth) throws Exception {
		MemberDto memberDto = memberService.findByUserId(auth.getName());
		log.debug("PlanController auth.getName : " + auth.getName());
		try {
			List<PlanResponseDto> planResponseDtoList = planService.findPlansByMemberDto(memberDto);
			log.debug("PlanController planResponseDtoList : " + planResponseDtoList);
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
