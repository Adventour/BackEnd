package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.FileInfoDto;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void writeArticle(BoardDto boardDto) throws SQLException;

	List<BoardDto> listArticle() throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws SQLException;

	void deleteArticle(int articleNo) throws SQLException;

	void registerFile(BoardDto boardDto) throws Exception;
	void deleteFile(int articleNo) throws Exception;
	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;

//	void updateHit(int articleNo) throws SQLException;
//	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

}
