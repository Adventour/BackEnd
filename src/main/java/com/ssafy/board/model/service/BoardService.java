package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.BoardDto;

public interface BoardService {

	void writeArticle(BoardDto boardDto) throws Exception;

	List<BoardDto> listArticle() throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws Exception;

	void deleteArticle(int articleNo, String path) throws Exception;

	String getImage(int articleNo) throws SQLException;
}
