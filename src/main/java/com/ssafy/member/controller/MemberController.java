package com.ssafy.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> regist(@RequestBody MemberDto memberDto) throws Exception {
		memberService.registerMember(memberDto);
		return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberDto memberDto, HttpSession session) throws Exception {
		MemberDto loginMember = memberService.loginMember(memberDto);
		session.setAttribute("userinfo", loginMember);
		return new ResponseEntity<MemberDto>(loginMember, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) throws Exception {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/modify")
	// TODO 앞의 인자들 DTO로 변경하던지 할 것
	public ResponseEntity<?> modify(String mid, String mname, String mpwd,HttpSession session) throws Exception {
		MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
		memberDto.setUserId(mid);
		memberDto.setUserName(mname);
		memberDto.setUserPwd(mpwd);
		memberService.modifyMember(memberDto);
		session.setAttribute("userinfo", memberDto);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
//	private String register(HttpServletRequest request, HttpServletResponse response) {
//		MemberDto memberDto = new MemberDto();
//		memberDto.setUserId(request.getParameter("rid"));
//		memberDto.setUserName(request.getParameter("rname"));
//		memberDto.setUserEmail(request.getParameter("remail1")+request.getParameter("remail2"));
//		memberDto.setUserPwd(request.getParameter("rpwd"));
//		memberDto.setUserSido(Integer.valueOf(request.getParameter("rsido")));
//		memberDto.setUserGugun(Integer.valueOf(request.getParameter("rgugun")));
//		
//		try {
//			memberService.registerMember(memberDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "/index.jsp";
//	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		String path = "";
//		
//		if ("register".equals(action)) {
////			path = register(request, response);
//			redirect(request, response, path);
//		} else if ("idcheck".equals(action)) {
//			int cnt = idcheck(request, response);
//		} else if ("mvlogin".equals(action)) {
//			path = "/user/login.jsp";
//			redirect(request, response, path);
//		} else if("login".equals(action)) {
//			path = login(request, response);
//			redirect(request, response, path);	
//		} else if("logout".equals(action)) {
//			path = logout(request, response);
//			redirect(request, response, path);
//		} else if("modify".equals(action)) {
//			path = modify(request, response);
//			redirect(request, response, path);
//		} 
//	}
//
//	private String modify(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto)session.getAttribute("userinfo");
//		memberDto.setUserId(request.getParameter("mid"));
//		memberDto.setUserName(request.getParameter("mname"));
//		memberDto.setUserPwd(request.getParameter("mpwd"));
//
//
//		try {
//			memberService.modifyMember(memberDto);
//			session.setAttribute("userinfo", memberDto);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		return "/index.jsp";
//
//	}
//	private String logout(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
////		session.removeAttribute("userinfo");
//		session.invalidate();
//		return "/index.jsp";
//	}
//	private String login(HttpServletRequest request, HttpServletResponse response) {
//		MemberDto memberDto = new MemberDto();
//		memberDto.setUserId(request.getParameter("lid"));
//		memberDto.setUserPwd(request.getParameter("lpwd"));
//		
//		System.out.println(memberDto);
//		
//		try {
//			MemberDto returnMemberDto = null;
//			returnMemberDto = memberService.loginMember(memberDto);
//			if(returnMemberDto != null) {
////				session 설정
//				HttpSession session = request.getSession();
//				session.setAttribute("userinfo", returnMemberDto);
//				
////				cookie 설정
//				String idsave = request.getParameter("saveid");
//				if("ok".equals(idsave)) { //아이디 저장을 체크 했다면.
//					Cookie cookie = new Cookie("ssafy_id", returnMemberDto.getUserId());
//					cookie.setPath(request.getContextPath());
////					크롬의 경우 400일이 최대
////					https://developer.chrome.com/blog/cookie-max-age-expires/
//					cookie.setMaxAge(60 * 60 * 24 * 365 * 40); //40년간 저장.
//					response.addCookie(cookie);
//				} else { //아이디 저장을 해제 했다면.
//					Cookie cookies[] = request.getCookies();
//					if(cookies != null) {
//						for(Cookie cookie : cookies) {
//							if("ssafy_id".equals(cookie.getName())) {
//								cookie.setMaxAge(0);
//								response.addCookie(cookie);
//								break;
//							}
//						}
//					}
//				}
//				return "/index.jsp";
//			}
//			else {
//				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
//				return "/index.jsp";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "로그인 중 에러 발생!!!");
//			return "/index.jsp";
//		}
//	}
//	private int idcheck(HttpServletRequest request, HttpServletResponse response) {
//		
//		return 1;
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		doGet(request, response);
//	}
//	
//	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response);
//	}
//	
//	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
//		response.sendRedirect(request.getContextPath() + path);
//	}

}
