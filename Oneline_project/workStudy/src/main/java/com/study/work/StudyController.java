package com.study.work;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudyController {

	@RequestMapping("viewJsp")
	public String jspView(){
		return "chkJsp";
	}

}
