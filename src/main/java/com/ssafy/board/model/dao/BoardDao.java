package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.BoardDto;

public interface BoardDao {

//	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	BoardDto getArticle(int articleNo) throws SQLException;
//	void updateHit(int articleNo) throws SQLException;
	
//	void modifyArticle(BoardDto boardDto) throws SQLException;
//	void deleteArticle(int articleNO) throws SQLException;
	void write(String id, String subject, String content) throws SQLException;
	List<BoardDto> list() throws SQLException;
	void modify(int articleNo, String subject, String content) throws SQLException;
	void delete(int articleNo) throws SQLException;
	
}
