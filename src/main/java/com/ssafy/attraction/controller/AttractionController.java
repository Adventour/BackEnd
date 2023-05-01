package com.ssafy.attraction.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.attraction.model.service.AttractionServiceImpl;


@WebServlet("/attraction")
public class AttractionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AttractionService attractionService= AttractionServiceImpl.getInstance();
       

    public AttractionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String temp=request.getParameter("seven");
		switch (temp) {
		case "list":
			System.out.println("doList");
			doList(request, response);
			break;

		default:
			break;
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<AttractionDto> list= new ArrayList<AttractionDto>();
		int sido=Integer.valueOf(request.getParameter("sido_code"));
		int gugun=Integer.valueOf(request.getParameter("gugun_code"));
		int contentType=Integer.valueOf(request.getParameter("content_type_id"));
		System.out.println(sido+" "+gugun+" "+contentType);
		list=attractionService.serviceList(sido, gugun, contentType);
		request.setAttribute("attList", list);
		request.setAttribute("attListSize", list.size());
		System.out.println(list.size());
		RequestDispatcher dispatcher=request.getRequestDispatcher("./location.jsp");
		try {
			dispatcher.forward(request, response);
			System.out.println(request.getAttribute("attListSize"));
			System.out.println("request success");
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
