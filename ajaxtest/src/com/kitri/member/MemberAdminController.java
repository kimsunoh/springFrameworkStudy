package com.kitri.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class MemberAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberDao memberDao;
	
	public void init() {
		memberDao = new MemberDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String word = new String(request.getParameter("word").getBytes("ISO-8859-1"), "UTF-8");
		
		List<MemberDto> list = memberDao.getMemberList(key, word);
		request.setAttribute("mlist", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("/member/memberxml.jsp");
		disp.forward(request, response);
	}

}





