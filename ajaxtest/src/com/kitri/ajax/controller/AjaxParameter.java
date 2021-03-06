package com.kitri.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class AjaxParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("이름 : " + name);
		request.setAttribute("name", name);
		
		RequestDispatcher disp = request.getRequestDispatcher("/param.jsp");
		disp.forward(request, response);
		
//		response.setContentType("text/plain;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("당신의 이름은 <b>" + name + "</b>입니다.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
	}

}
