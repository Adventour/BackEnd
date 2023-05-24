package com.ssafy.board.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/board")
@Api(tags = "게시판")
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/write")
    @ApiOperation(value = "게시글 작성", notes = "게시글 작성 요청 API 입니다.")
    public ResponseEntity<?> write(@ModelAttribute BoardDto boardDto, @RequestParam("upfile") MultipartFile file) throws Exception {
        System.out.println("CONTROLLER : "+file);
        boardService.writeArticle(boardDto, file);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/")
    @ApiOperation(value = "게시글 리스트 보기", notes = "모든 게시글 요청 API 입니다.")
    public ResponseEntity<?> list() throws Exception {
        List<BoardDto> boardList = boardService.listArticle();
        return new ResponseEntity<List<BoardDto>>(boardList, HttpStatus.OK);
    }
    @GetMapping("/{contentId}")
    @ApiOperation(value = "특정 관광지 리뷰 게시글 보기", notes = "특정 관광지 리뷰 게시글 요청 API 입니다.")
    public ResponseEntity<?> listAttraction(@PathVariable("contentId") String contentId) throws Exception {
        List<BoardDto> boardList = boardService.listDetailArticle(contentId);
        return new ResponseEntity<List<BoardDto>>(boardList, HttpStatus.OK);
    }

    @GetMapping("list/{articleNo}")
    @ApiOperation(value = "게시글 보기", notes = "게시글 보기 요청 API 입니다.")
    public ResponseEntity<?> view(@PathVariable("articleNo") String articleNo) throws Exception {
        BoardDto boardDto = boardService.getArticle(Integer.valueOf(articleNo));
        return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
    }
    @GetMapping("img/{articleNo}")
    @ApiOperation(value = "이미지 파일 경로 보기", notes = "이미지 파일 경로 보기 요청 API 입니다.")
    public ResponseEntity<?> viewImg(@PathVariable("articleNo") String articleNo) throws Exception {
        String imgUrl = boardService.getImage(Integer.valueOf(articleNo));
        return new ResponseEntity<String>(imgUrl, HttpStatus.OK);
    }

    @PostMapping("/list/{articleNo}")
    @ApiOperation(value = "게시글 수정", notes = "게시글 수정 요청 API 입니다.")
    public ResponseEntity<?> modify(@PathVariable("articleNo") String articleNo, @ModelAttribute BoardDto boardDto, @RequestParam("upfile") MultipartFile file)
            throws Exception {
        boardDto.setArticleNo(Integer.valueOf(articleNo));
        boardService.modifyArticle(boardDto, file);
        // TODO 바뀐 데이터 보내줘야 함
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/list/{articleNo}")
    @ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 요청 API 입니다.")
    public ResponseEntity<?> delete(@PathVariable("articleNo") String articleNo) throws Exception {
        // TODO 추후에 자격 검증 필요
        boardService.deleteArticle(Integer.valueOf(articleNo));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
