package com.ssafy.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.reply.model.dto.ReplyDto;
import com.ssafy.reply.model.service.ReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reply")
@Api(tags = "댓글")
public class ReplyController {
	private ReplyService replyService;
	
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	@PostMapping("/list/{articleNo}")
	@ApiOperation(value = "댓글 작성", notes = "댓글 작성 요청 API 입니다.")
	public ResponseEntity<?> writeReply(@RequestBody ReplyDto replyDto)
			throws Exception {
		System.out.println("유저아이디~~~~~~~~~~~~~~~~"+ replyDto.getUserId());
		replyService.writeReply(replyDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/list/{articleNo}")
	@ApiOperation(value = "댓글 리스트 보기", notes = "모든 댓글 요청 API 입니다.")
	public ResponseEntity<?> listReply(@PathVariable String articleNo) throws Exception {
		List<ReplyDto> list = replyService.listReply(Integer.valueOf(articleNo));
		return new ResponseEntity<List<ReplyDto>>(list, HttpStatus.OK);
	}

	@PutMapping("/list/{articleNo}")
	@ApiOperation(value = "댓글 수정", notes = "댓글 수정 요청 API 입니다.")
	public ResponseEntity<?> modifyReply(@RequestBody ReplyDto replyDto) throws Exception {
		replyService.modifyReply(replyDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/list/{articleNo}")
	@ApiOperation(value = "댓글 삭제", notes = "댓글 삭제 요청 API 입니다.")
	public ResponseEntity<?> deleteReply(@RequestBody ReplyDto replyDto) throws Exception {
		replyService.deleteReply(replyDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
