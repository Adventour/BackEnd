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

@RestController
@RequestMapping("/board")
public class BoardController {

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/")
	public ResponseEntity<?> list() throws Exception {
		List<BoardDto> boardList = boardService.listArticle();
		return new ResponseEntity<List<BoardDto>>(boardList, HttpStatus.OK);
	}
	
	@PostMapping("/write")
	public ResponseEntity<?> write(@RequestBody BoardDto boardDto, HttpSession session) throws Exception {
//		String id = (String) session.getAttribute("loginUser");
		boardService.writeArticle(boardDto);
//		boardService.write(id, boardDto.getSubject(), boardDto.getContent());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("list/{articleNo}")
	public ResponseEntity<?> view(@PathVariable("articleNo") String articleNo) throws Exception {
		BoardDto boardDto = boardService.getArticle(Integer.valueOf(articleNo));
//		BoardDto boardDto = boardService.view(Integer.valueOf(articleNo));
		return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
	}
	
	@PutMapping("/list/{articleNo}")
	public ResponseEntity<?> modify(@PathVariable("articleNo") @RequestBody BoardDto boardDto) throws Exception {
		
		// TODO 추후에 modify BoardDto 이용으로 변경
		boardService.modifyArticle(boardDto);
//		boardService.modify(boardDto.getArticleNo(), boardDto.getSubject(), boardDto.getContent());
		// TODO 바뀐 데이터 보내줘야 함
		return new ResponseEntity<Void>(HttpStatus.OK); 
	}
	
	@DeleteMapping("/list/{articleNo}")
	public ResponseEntity<?> delete(@PathVariable("articleNo") String articleNo) throws Exception {
		// TODO 추후에 자격 검증 필요
		boardService.deleteArticle(Integer.valueOf(articleNo));
//		boardService.delete(Integer.valueOf(articleNo));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
