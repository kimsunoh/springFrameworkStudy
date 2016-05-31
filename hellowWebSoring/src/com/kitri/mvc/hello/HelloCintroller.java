package com.kitri.mvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloCintroller {
	
	/*얘가 하는 일은 MVC에서의 Action에 해당*/
	@RequestMapping("/hello.html")
	public ModelAndView hello(MemberDto memberDto){
		ModelAndView mav = new ModelAndView();
 		mav.addObject("memberDto.getId",id);
		mav.setViewName("hello");
		return mav;
	}
}
