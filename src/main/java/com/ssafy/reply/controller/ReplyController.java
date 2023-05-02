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

@RestController
@RequestMapping("/board")
public class ReplyController {
	private ReplyService replyService;

	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	@PostMapping("/list/{articleNo}/replies")
	public ResponseEntity<?> writeReply(@PathVariable String articleNo, @RequestBody ReplyDto replyDto)
			throws Exception {
		replyDto.setArticleNo(Integer.valueOf(articleNo));
		replyService.writeReply(replyDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/list/{articleNo}/replies")
	public ResponseEntity<?> listReply(@PathVariable String articleNo) throws Exception {
		List<ReplyDto> list = replyService.listReply(Integer.valueOf(articleNo));
		return new ResponseEntity<List<ReplyDto>>(list, HttpStatus.OK);
	}

	@PutMapping("/list/{articleNo}/replies")
	public ResponseEntity<?> modifyReply(@RequestBody ReplyDto replyDto) throws Exception {
		replyService.modifyReply(replyDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/list/{articleNo}/replies")
	public ResponseEntity<?> deleteReply(@RequestBody ReplyDto replyDto) throws Exception {
		replyService.deleteReply(replyDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
