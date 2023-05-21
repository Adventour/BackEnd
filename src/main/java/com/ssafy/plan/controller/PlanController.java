package com.ssafy.plan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.plan.model.dto.PlanDetailDto;
import com.ssafy.plan.model.dto.PlanDto;
import com.ssafy.plan.model.service.PlanService;
import com.ssafy.plan.model.service.PlanServiceImp;
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
	@GetMapping("/search")
	public ResponseEntity<?> searchPlan(@RequestBody MemberDto memberDto) throws Exception {
		List<PlanDto> planList = planService.findPlansByUserId(memberDto);
		return new ResponseEntity<>(planList, HttpStatus.OK);
	}

	@GetMapping("/details")
	public ResponseEntity<?> searchPlanDetail(@RequestBody PlanDto planDto) throws Exception {
		List<PlanDetailDto> planDetailDtoList = planService.findPlanDetailsByPlanId(planDto);
		return new ResponseEntity<>(planDetailDtoList, HttpStatus.OK);
	}
}
