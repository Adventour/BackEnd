package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void writeArticle(BoardDto boardDto) throws SQLException;

	List<BoardDto> listArticle() throws SQLException;
	List<BoardDto> listDetailArticle(String contentId) throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
	void deleteReplies(int articleNo) throws Exception;

	String getImage(int articleNo) throws SQLException;

//	void updateHit(int articleNo) throws SQLException;
//	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

}
