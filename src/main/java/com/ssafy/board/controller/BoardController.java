package com.ssafy.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;

import com.ssafy.board.model.dto.FileInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/board")
@Api(tags = "게시판")
public class BoardController {

    @Value("${file.path}")
    private String uploadPath;

    @Value("${file.imgPath}")
    private String uploadimgPath;

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/write")
    @ApiOperation(value = "게시글 작성", notes = "게시글 작성 요청 API 입니다.")
    public ResponseEntity<?> write(@ModelAttribute BoardDto boardDto, @RequestParam("upfile") MultipartFile[] files) throws Exception {
//		String id = (String) session.getAttribute("loginUser");
//		boardDto.setUserId(id);
//        boardService.writeArticle(boardDto);
//		boardService.write(id, boardDto.getSubject(), boardDto.getContent());

//		FileUpload 관련 설정.
        if (!files[0].isEmpty()) {
//			String realPath = servletContext.getRealPath(UPLOAD_PATH);
//			String realPath = servletContext.getRealPath("/resources/img");
            String today = new SimpleDateFormat("yyMMdd").format(new Date());
            String saveFolder = uploadPath + File.separator + today;
            File folder = new File(saveFolder);
            if (!folder.exists())
                folder.mkdirs();
            List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
            for (MultipartFile mfile : files) {
                FileInfoDto fileInfoDto = new FileInfoDto();
                String originalFileName = mfile.getOriginalFilename();
                if (!originalFileName.isEmpty()) {
                    String saveFileName = UUID.randomUUID().toString()
                            + originalFileName.substring(originalFileName.lastIndexOf('.'));
                    fileInfoDto.setSaveFolder(today);
                    fileInfoDto.setOriginalFile(originalFileName);
                    fileInfoDto.setSaveFile(saveFileName);
                    boardDto.setSaveFile(saveFileName);
                    mfile.transferTo(new File(folder, saveFileName));
                }
                fileInfos.add(fileInfoDto);
            }
            boardDto.setFileInfos(fileInfos);
        }

        boardService.writeArticle(boardDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/")
    @ApiOperation(value = "게시글 리스트 보기", notes = "모든 게시글 요청 API 입니다.")
    public ResponseEntity<?> list() throws Exception {
        List<BoardDto> boardList = boardService.listArticle();
        return new ResponseEntity<List<BoardDto>>(boardList, HttpStatus.OK);
    }

    @GetMapping("list/{articleNo}")
    @ApiOperation(value = "게시글 보기", notes = "게시글 보기 요청 API 입니다.")
    public ResponseEntity<?> view(@PathVariable("articleNo") String articleNo) throws Exception {
        BoardDto boardDto = boardService.getArticle(Integer.valueOf(articleNo));
//		BoardDto boardDto = boardService.view(Integer.valueOf(articleNo));
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
    public ResponseEntity<?> modify(@PathVariable("articleNo") String articleNo, @ModelAttribute BoardDto boardDto, @RequestParam("upfile") MultipartFile[] files)
            throws Exception {
        // TODO 추후에 modify BoardDto 이용으로 변경
        //		FileUpload 관련 설정.
        if (!files[0].isEmpty()) {
//			String realPath = servletContext.getRealPath(UPLOAD_PATH);
//			String realPath = servletContext.getRealPath("/resources/img");
            String today = new SimpleDateFormat("yyMMdd").format(new Date());
            String saveFolder = uploadPath + File.separator + today;
            File folder = new File(saveFolder);
            if (!folder.exists())
                folder.mkdirs();
            List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
            for (MultipartFile mfile : files) {
                FileInfoDto fileInfoDto = new FileInfoDto();
                String originalFileName = mfile.getOriginalFilename();
                if (!originalFileName.isEmpty()) {
                    String saveFileName = UUID.randomUUID().toString()
                            + originalFileName.substring(originalFileName.lastIndexOf('.'));

                    System.out.println("일단 파일은 왔다:::::"+saveFileName);
                    fileInfoDto.setSaveFolder(today);
                    fileInfoDto.setOriginalFile(originalFileName);
                    fileInfoDto.setSaveFile(saveFileName);
                    mfile.transferTo(new File(folder, saveFileName));
                }
                fileInfos.add(fileInfoDto);
            }
            boardDto.setFileInfos(fileInfos);
        }
        boardDto.setArticleNo(Integer.valueOf(articleNo));
        System.out.println(boardDto.getArticleNo());
        boardService.modifyArticle(boardDto);
//		boardService.modify(boardDto.getArticleNo(), boardDto.getSubject(), boardDto.getContent());
        // TODO 바뀐 데이터 보내줘야 함
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/list/{articleNo}")
    @ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 요청 API 입니다.")
    public ResponseEntity<?> delete(@PathVariable("articleNo") String articleNo) throws Exception {
        // TODO 추후에 자격 검증 필요
        boardService.deleteArticle(Integer.valueOf(articleNo), uploadPath);
//		boardService.delete(Integer.valueOf(articleNo));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
