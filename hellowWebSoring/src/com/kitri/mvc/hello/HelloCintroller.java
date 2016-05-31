package com.kitri.mvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloCintroller {
	
	/*�갡 �ϴ� ���� MVC������ Action�� �ش�*/
	@RequestMapping("/hello.html")
	public ModelAndView hello(MemberDto memberDto){
		ModelAndView mav = new ModelAndView();
 		mav.addObject("memberDto.getId",id);
		mav.setViewName("hello");
		return mav;
	}
}
