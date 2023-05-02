//package com.ssafy.board.model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.ssafy.board.model.dto.BoardDto;
//import com.ssafy.util.DBUtil;
//
//public class BoardDaoImp implements BoardDao {
//	private static BoardDao instance = new BoardDaoImp();
//	private DBUtil util;
//	
//	private BoardDaoImp() {
//		util = DBUtil.getInstance();
//	}
//
//	public static BoardDao getInstance() {
//		return instance;
//	}
//	
//	/**
//	 * 게시판에 글 쓰기
//	 * Board 테이블에 새로운 글을 저장
//	 * @throws SQLException 
//	 */
//	@Override
//	public void write(String id, String subject, String content) throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = util.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("insert into board (user_id, subject, content) \n");
//			sql.append("values (?, ?, ?)");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, id);
//			pstmt.setString(2, subject);
//			pstmt.setString(3, content);
//			pstmt.executeUpdate();
//		} finally {
//			util.close(pstmt, conn);
//		}
//	}
//	
//	/**
//	 * 게시판 글 목록
//	 * Board 테이블의 모든 게시글을 return
//	 * @throws SQLException 
//	 */
//	@Override
//	public List<BoardDto> list() throws SQLException {
//		List<BoardDto> list = new ArrayList<>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = util.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select * \n");
//			sql.append("from board \n");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				BoardDto boardDto = new BoardDto();
//				boardDto.setArticleNo(rs.getInt("article_no"));
//				boardDto.setUserId(rs.getString("user_id"));
//				boardDto.setSubject(rs.getString("subject"));
//				boardDto.setContent(rs.getString("content"));
//				boardDto.setHit(rs.getInt("hit"));
//				boardDto.setRegisterTime(rs.getString("register_time"));
//				
//				list.add(boardDto);
//			}
//		} finally {
//			util.close(rs, pstmt, conn);
//		}
//		
//		return list;
//	}
//	
//	/**
//	 * 특정 게시글 조회
//	 * Board에서 articleNo와 같은 게시글 return
//	 * @throws SQLException 
//	 */
//	@Override
//	public BoardDto getArticle(int articleNo) throws SQLException {
//		BoardDto board = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = util.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select * \n");
//			sql.append("from board \n");
//			sql.append("where article_no = ?");
//			
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setInt(1, articleNo);
//			
//			rs = pstmt.executeQuery();
//			
//			if (rs.next()) {
//				board = new BoardDto();
//				board.setArticleNo(rs.getInt("article_no"));
//				board.setUserId(rs.getString("user_id"));
//				board.setSubject(rs.getString("subject"));
//				board.setContent(rs.getString("content"));
//				board.setHit(rs.getInt("hit"));
//				board.setRegisterTime(rs.getString("register_time"));
//			}
//		} finally {
//			util.close(rs, pstmt, conn);
//		}
//		return board;
//	}
//	
//	/**
//	 * 게시글 수정
//	 * articleNo가 같은 article의 subject와 content를 수정
//	 * @throws SQLException 
//	 */
//	@Override
//	public void modify(int articleNo, String subject, String content) throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = util.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("update board \n");
//			sql.append("set subject = ?, content = ? \n");
//			sql.append("where article_no = ?");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setString(1, subject);
//			pstmt.setString(2, content);
//			pstmt.setInt(3, articleNo);
//			pstmt.executeUpdate();
//		} finally {
//			util.close(pstmt, conn);
//		}	
//	}
//	
//	/**
//	 * 게시글 삭제
//	 * articleNo가 같은 article을 삭제
//	 * @throws SQLException 
//	 */
//	@Override
//	public void delete(int articleNo) throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = util.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("delete from board \n");
//			sql.append("where article_no = ?");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setInt(1, articleNo);
//			pstmt.executeUpdate();
//		} finally {
//			util.close(pstmt, conn);
//		}			
//	}
//}
