package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.BoardDto;

public interface BoardService {

	void write(String id, String subject, String content) throws SQLException;

	List<BoardDto> list() throws SQLException;

	BoardDto view(int articleNo) throws SQLException;

	BoardDto mvmodify(int articleNo) throws SQLException;

	void modify(int articleNo, String subject, String content) throws SQLException;

	void delete(int articleNo) throws SQLException;

}
