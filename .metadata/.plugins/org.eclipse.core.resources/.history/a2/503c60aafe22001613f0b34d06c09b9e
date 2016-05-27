package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json")
public class MemberJsonController extends HttpServlet {

	private MemberDao memberDao;
	
	public void init() {
		memberDao = new MemberDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		System.out.println(key + "\t" + word);
		
		List<MemberDto> list = memberDao.getMemberList(key, word);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		
		for (MemberDto memberDto : list) {
			JSONObject job = new JSONObject();
			job.put("uid", memberDto.getId());
			job.put("uname", memberDto.getName());
			job.put("uemail", memberDto.getEmail());
			
			jarray.add(job);
		}
		json.put("jlist", jarray);
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
	}

}


//{"jlist" : [{ "name": "안효인", "id": "java2" }, { "name": "안효인", "id": "java2" }, { "name": "안효인", "id": "java2" }]}




