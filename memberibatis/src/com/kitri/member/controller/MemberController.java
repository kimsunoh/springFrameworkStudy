package com.kitri.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.member.model.MemberDto;
import com.kitri.member.model.MemberService;
import com.kitri.member.model.MemberServiceImpl;
import com.kitri.member.model.ZipDto;
import com.kitri.util.Encoder;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	MemberService memberService;
	
	public MemberController() {
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		excute(request, response);
	}

	//post로 오나 get으로 오나 get으로 처리 할 수 있음	
	private void excute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "/index.jsp";
		boolean flag = true;
		
		System.out.println("act : "+act);
		
		if ("".equals(act)){
		} else if("mvlogin".equals(act)) {
			path = "/login/login.jsp";
		} else if("mvjoin".equals(act)) {
			path = "/join/member.jsp";						
		} else if ("mvzip".equals(act)) {	
			path = "/join/zipsearch.jsp";
		} else if ("zipsearch".equals(act)) {
			String dong = Encoder.isoToEuc(request.getParameter("dong"));
			List<ZipDto> list = memberService.zipSearch(dong);
			request.setAttribute("ziplist", list);
			request.setAttribute("searchdong", dong);
			path = "/join/zipsearch.jsp";
			flag = false;
		} else if ("mvidcheck".equals(act)) {
			path = "/join/idcheck.jsp";
		} else if ("idsearch".equals(act)) {
			String id = Encoder.isoToEuc(request.getParameter("id"));
			int count = memberService.idCheck(id);
			request.setAttribute("count", count);
			request.setAttribute("searchid", id);
			path = "/join/idcheck.jsp";
			flag = false;
		} else if ("register".equals(act)) {
			MemberDto memberDto = new MemberDto();
			memberDto.setName(request.getParameter("name"));
			memberDto.setId(request.getParameter("id"));
			memberDto.setPass(request.getParameter("pass"));
			memberDto.setEmail1(request.getParameter("email1"));
			memberDto.setEmail2(request.getParameter("email2"));
			memberDto.setZip1(request.getParameter("zip1"));
			memberDto.setZip2(request.getParameter("zip2"));
			memberDto.setAddr1(request.getParameter("addr1"));
			memberDto.setAddr2(request.getParameter("addr2"));
			memberDto.setTel1(request.getParameter("tel1"));
			memberDto.setTel2(request.getParameter("tel2"));
			memberDto.setTel3(request.getParameter("tel3"));
			
			int cnt = memberService.register(memberDto);
			if (cnt != 0) {
				request.setAttribute("userInfo", memberDto);
				path = "/join/joinok.jsp";
				flag = false;
			} else {
				path = "/join/joinfail.jsp";
			}
		}else if("login".equals(act)){
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			MemberDto memberDto = memberService.login(id, pass);
			if(memberDto !=null){
				path = "/login/loginok.jsp";
				
				/* *********session설정********* */
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				//flag=false;
				//session이 살아있는 동안에는 계속 유지 되어 있음
				/**/
				
				/* ***********cookie설정********* */
				String idsave = request.getParameter("idsv");
				if("idsave".equals(idsave)) {//아이디 저장체크가 됬을경우
					Cookie cookie = new Cookie("nid_sid", id);
					cookie.setPath(root);
					cookie.setMaxAge(60 * 60 * 24 * 1000);
					response.addCookie(cookie);
				}else {//아이디 저장체크를 풀었을 경우
					Cookie cookie[] = request.getCookies();
					
					if(cookie != null) {
						int len = cookie.length;
						for(int i=0 ; i<len ; i++) {
							if("nid_sid".equals(cookie[i].getName())){
								cookie[i].setMaxAge(0);
								cookie[i].setPath(root);
								response.addCookie(cookie[i]);
								break;
							}
						}
					}
				}
				/**/
			}else{
				path = "/login/loginfail.jsp";
			}
			
		}else if("mail".equals(act)){
			path="/mail/list.jsp";
		}else if("logout".equals(act)){
			HttpSession session = request.getSession();
			session.removeAttribute("userInfo");
			//세션을 얻어오고 세션 안에 있는 userInfo를 지워버리면 됨
			path = "/login/login.jsp";
		}else if("pop1".equals(act)) {
			path="/popup/pop1.jsp?flag=false";
		}else if("popcheck".equals(act)){
			Cookie cookie = new Cookie("ad", "checked");
			
			cookie.setPath(root);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			path = "/popup/pop1.jsp?flag=true";
		}
		
		if (flag) {			
			response.sendRedirect(root+path);
		} else {
			/*Spring은 RequestDispatcher가 default*/
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);		
		}
		
	}
}
