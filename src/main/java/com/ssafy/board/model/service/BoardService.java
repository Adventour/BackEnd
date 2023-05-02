package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.BoardDto;

public interface BoardService {

	void writeArticle(BoardDto boardDto) throws SQLException;

	List<BoardDto> listArticle() throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws SQLException;

	void deleteArticle(int articleNo) throws SQLException;

}
