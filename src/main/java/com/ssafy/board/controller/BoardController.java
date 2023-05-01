package com.ssafy.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImp;

//@Controller("/board")
public class BoardController {

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		try {
			String action = request.getParameter("action");
			System.out.println(action);
			if ("mvwrite".equals(action)) {
				path = "/board/mvwritearticle.jsp";
				redirect(request, response, path);
			} else if ("write".equals(action)) {
				path = write(request, response);
				forward(request, response, path);
			} else if ("list".equals(action)) {
				path = list(request, response); 
				forward(request, response, path);
			} else if ("view".equals(action)) {
				path = view(request, response); 
				forward(request, response, path);
			} else if ("mvmodify".equals(action)) {
				path = mvmodify(request, response);
				forward(request, response, path);
			} else if ("modify".equals(action)) {
				path = modify(request, response);
				forward(request, response, path);
			} else if ("delete".equals(action)) {
				path = delete(request, response);
				redirect(request, response, path);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			path = "/error/error.jsp";
			redirect(request, response, path);
		}
	}
	
	/**
	 * 특정 게시글 페이지에서 글삭제 버튼을 눌렀을 때 동작
	 * DB에서 articleNo의 article 삭제 
	 * 
	 * hidden으로 articleNo가 필요
	 * 게시글 리스트로 다시 돌아감
	 * @throws SQLException 
	 */
	private String delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int articleNo = Integer.valueOf(request.getParameter("articleNo"));
		
		boardService.delete(articleNo);
		
		return "/board?action=list";
	}

	/**
	 * 게시글 수정 페이지에서 글수정 버튼을 눌렀을 때 동작
	 * DB에서 게시글의 내용을 수정 
	 * 
	 * hidden으로 articleNo가 필요
	 * 게시글 보기로 다시 돌아감
	 * @throws SQLException 
	 */
	private String modify(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int articleNo = Integer.valueOf(request.getParameter("articleNo"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		boardService.modify(articleNo, subject, content);
		
		return "/board?action=view&articleNo=" + articleNo;
	}

	/**
	 * 게시판에서 특정 글에서 수정 버튼을 눌렀을 때 동작
	 * hidden을 통해서 글 번호(articleNo)가 필요 
	 * 게시글 수정 페이지로 이동
	 * @throws SQLException 
	 */
	private String mvmodify(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int articleNo = Integer.valueOf(request.getParameter("articleNo"));
		
		BoardDto board = boardService.mvmodify(articleNo);		
		request.setAttribute("article", board);		
		
		return "/board/modify.jsp";
	}

	/**
	 * 게시판에서 특정 글을 클릭했을 때 동작
	 * hidden을 통해서 글 번호(articleNo)가 필요 
	 * @throws SQLException 
	 */
	private String view(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int articleNo = Integer.valueOf(request.getParameter("articleNo"));
		
		BoardDto board = boardService.view(articleNo);		
		request.setAttribute("article", board);
		
		return "/board/view.jsp";
	}

	/**
	 * 게시판 글 목록을 조회했을 때 동작
	 * Board 테이블에 있는 data를 return
	 * @throws SQLException 
	 */
	private String list(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<BoardDto> boardList = boardService.list();
		request.setAttribute("boardList", boardList);
		
		return "/board/list.jsp";
	}

	/**
	 * 게시판에서 글작성 버튼을 눌렀을 때 동작
	 * DB에 글의 내용을 저장하고
	 * 등록 결과로 이동 
	 * 
	 * id에 대한 정보는 session으로 가져올 예정 (loginUser)
	 * @throws SQLException 
	 */
	private String write(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = (String) request.getSession().getAttribute("loginUser");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("!!!!!");
		boardService.write(id, subject, content);
		
		return "/board?action=list";
	}
}
