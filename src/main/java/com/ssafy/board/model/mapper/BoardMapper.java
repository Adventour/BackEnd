package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.BoardDto;

public interface BoardMapper {

	void writeArticle(BoardDto boardDto) throws SQLException;

	List<BoardDto> listArticle() throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws SQLException;

	void deleteArticle(int articleNo) throws SQLException;

//	void updateHit(int articleNo) throws SQLException;
//	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

}
