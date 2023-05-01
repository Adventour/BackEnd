package com.ssafy.hotplace.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.hotplace.model.service.HotplaceService;
import com.ssafy.hotplace.model.service.HotplaceServiceImpl;

@WebServlet("/hotplace")
public class HotplaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HotplaceService hotplaceService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		hotplaceService = HotplaceServiceImpl.getInstance();
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
	
			if ("mvhotplace".equals(action)) {
				path = "/hotplace.jsp";
				redirect(request, response, path);
			}
		} catch (Exception e) {
			path = "/error/error.jsp";
			redirect(request, response, path);
		}
	}

}
