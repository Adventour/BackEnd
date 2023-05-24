package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.BoardDto;
import org.springframework.web.multipart.MultipartFile;

public interface BoardService {

	void writeArticle(BoardDto boardDto, MultipartFile file) throws Exception;

	List<BoardDto> listArticle() throws SQLException;
	List<BoardDto> listDetailArticle(String contentId) throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto, MultipartFile file) throws Exception;

	void deleteArticle(int articleNo) throws Exception;

	String getImage(int articleNo) throws SQLException;
}
