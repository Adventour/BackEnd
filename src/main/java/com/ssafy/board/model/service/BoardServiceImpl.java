package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardServiceImpl implements BoardService {
	private final S3FileUploadService s3FileUploadService;
	private BoardMapper boardMapper;
	
	public BoardServiceImpl(S3FileUploadService s3FileUploadService, BoardMapper boardMapper) {
		this.s3FileUploadService = s3FileUploadService;
		this.boardMapper = boardMapper;
	}

	@Transactional
	public void writeArticle(BoardDto boardDto, MultipartFile file) throws Exception {
		if(file != null)
			boardDto.setSaveFile(s3FileUploadService.upload(file));
		boardMapper.writeArticle(boardDto);
	}

	public    List<BoardDto> listArticle() throws SQLException {
		return boardMapper.listArticle();
	}
	public    List<BoardDto> listDetailArticle(String contentId) throws SQLException {
		return boardMapper.listDetailArticle(contentId);
	}

	public BoardDto getArticle(int articleNo) throws SQLException {
		boardMapper.updateHit(articleNo);
		return boardMapper.getArticle(articleNo);
	}

	public void modifyArticle(BoardDto boardDto, MultipartFile file) throws Exception {
		if (!file.getOriginalFilename().equals(boardDto.getSaveFile()))
			boardDto.setSaveFile(s3FileUploadService.upload(file));
		boardMapper.modifyArticle(boardDto);
	}

	public void deleteArticle(int articleNo) throws Exception {
		boardMapper.deleteReplies(articleNo);
		boardMapper.deleteArticle(articleNo);
	}

	@Override
	public String getImage(int articleNo) throws SQLException {
		return boardMapper.getImage(articleNo);
	}
}
