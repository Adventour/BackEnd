package com.ssafy.board.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

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

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board")
@Api(tags = "게시판")
public class BoardController {

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/")
	@ApiOperation(value = "게시글 리스트 보기", notes = "모든 게시글 요청 API 입니다.")
	public ResponseEntity<?> list() throws Exception {
		List<BoardDto> boardList = boardService.list();
		return new ResponseEntity<List<BoardDto>>(boardList, HttpStatus.OK);
	}
	
	@PostMapping("/write")
	@ApiOperation(value = "게시글 작성", notes = "게시글 작성 요청 API 입니다.")
	public ResponseEntity<?> write(@RequestBody BoardDto boardDto, HttpSession session) throws Exception {
		String id = (String) session.getAttribute("loginUser");
		boardService.write(id, boardDto.getSubject(), boardDto.getContent());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("list/{articleNo}")
	@ApiOperation(value = "게시글 보기", notes = "게시글 보기 요청 API 입니다.")
	public ResponseEntity<?> view(@PathVariable("articleNo") String articleNo) throws Exception {
		BoardDto boardDto = boardService.view(Integer.valueOf(articleNo));
		return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
	}
	
	@PutMapping("/list/{articleNo}")
	@ApiOperation(value = "게시글 수정", notes = "게시글 수정 요청 API 입니다.")
	public ResponseEntity<?> modify(@PathVariable("articleNo") @RequestBody BoardDto boardDto) throws Exception {
		
		// TODO 추후에 modify BoardDto 이용으로 변경
		boardService.modify(boardDto.getArticleNo(), boardDto.getSubject(), boardDto.getContent());
		
		// TODO 바뀐 데이터 보내줘야 함
		return new ResponseEntity<Void>(HttpStatus.OK); 
	}
	
	@DeleteMapping("/list/{articleNo}")
	@ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 요청 API 입니다.")
	public ResponseEntity<?> delete(@PathVariable("articleNo") String articleNo) throws Exception {
		// TODO 추후에 자격 검증 필요
		boardService.delete(Integer.valueOf(articleNo));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
