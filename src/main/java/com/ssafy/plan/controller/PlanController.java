package com.ssafy.plan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.plan.model.service.PlanService;
import com.ssafy.plan.model.service.PlanServiceImp;

@WebServlet("/plan")
public class PlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PlanService planService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		planService = PlanServiceImp.getInstance();
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
	
			if ("mvplan".equals(action)) {
				path = "/plan.jsp";
				redirect(request, response, path);
			} else if ("search".equals(action)) {
//				path = search(request, response);
//				forward(request, response, path);
			} 
		} catch (Exception e) {
			path = "/error/error.jsp";
			redirect(request, response, path);
		}
	}

}
