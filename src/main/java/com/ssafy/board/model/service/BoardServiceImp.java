package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImp;
import com.ssafy.board.model.dto.BoardDto;

@Service
public class BoardServiceImp implements BoardService {
	private static BoardService instance = new BoardServiceImp();
	private BoardDao boardDao;

	private BoardServiceImp() {
		boardDao = BoardDaoImp.getInstance();
	}

	public static BoardService getInstance() {
		return instance;
	}

	@Override
	public void write(String id, String subject, String content) throws SQLException {
		boardDao.write(id, subject, content);
	}

	@Override
	public List<BoardDto> list() throws SQLException {
		return boardDao.list();
	}
	
	@Override
	public BoardDto view(int articleNo) throws SQLException {
		return boardDao.getArticle(articleNo);
	}
	
	@Override
	public BoardDto mvmodify(int articleNo) throws SQLException {
		return boardDao.getArticle(articleNo);
	}
	
	@Override
	public void modify(int articleNo, String subject, String content) throws SQLException {
		boardDao.modify(articleNo, subject, content);
	}
	
	@Override
	public void delete(int articleNo) throws SQLException {
		boardDao.delete(articleNo);
	}
}
