package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	public void writeArticle(BoardDto boardDto) throws SQLException {
		boardMapper.writeArticle(boardDto);
	}

	public List<BoardDto> listArticle() throws SQLException {
		return boardMapper.listArticle();
	}

	public BoardDto getArticle(int articleNo) throws SQLException {
		return boardMapper.getArticle(articleNo);
	}

	public void modifyArticle(BoardDto boardDto) throws SQLException {
		boardMapper.modifyArticle(boardDto);
	}

	public void deleteArticle(int articleNo) throws SQLException {
		boardMapper.deleteArticle(articleNo);
	}
}
