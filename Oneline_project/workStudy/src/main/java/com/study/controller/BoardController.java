package com.study.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.service.BoardService;
import com.study.vo.BoardVO;
import com.study.vo.PageVO;

@컨트롤러
public class BoardController {
qweqwe
	@Resource(name = "a")
	BoardService boardservice;
	
	@Autowired
	SqlSessionTemplate session;
	
	ModelAndView mv = new ModelAndView();
	
	@RequestMapping("board.do")
	public ModelAndView List(Model model, HttpServletRequest request) {
		ModelAndView mv =new ModelAndView();
		Map<String,Object> map = new HashMap<String, Object>();
		String searchKeyword = request.getParameter("searchKeyword");
		String search = request.getParameter("search");
		map.put("searchKeyword", searchKeyword);
		map.put("search", search);
		List<BoardVO> boardlist= boardservice.boardlist(map);
		
		mv.addObject("boardlist", boardlist);
		mv.setViewName("list");
		System.out.println(mv);
		aksndflkansdfklnadsfkln
		alknflkdasnklfn
		return mv;
	}
	
	@RequestMapping("writeView")
	public String writeView(){
		return "write";
	}
	
	@RequestMapping(value="detail" , method=RequestMethod.GET)
	public String detail(@ModelAttribute("seq") int seq, Model model){
		BoardVO vo = boardservice.detail(seq);
		model.addAttribute("list", vo);
		return "/write";
	}
	
	@RequestMapping(value="update")
	public String update(Model model,BoardVO vo, HttpServletRequest request){
		
		int seq =Integer.parseInt(request.getParameter("SEQ"));
		int cnt = boardservice.update(vo);
		
		return "redirect:board.do";
	}
	
	@RequestMapping("ajaxView")
	public String ajaxView(){
		return "ajaxView";
	}
	
	@RequestMapping("ajax.do")
	@ResponseBody
	public  String ajaxStr(HttpServletRequest request){
		String txt= request.getParameter("txt");
		System.out.println("확占쏙옙 ::::::::::" + txt);
		String str = "123";
		String str1 = txt+str;
		
		return str1;
	}
	
	@RequestMapping("ajax1.do")
	public String ajax1(){
		return "ajaxTable";
	}
	
	@RequestMapping("ajaxBoard.do")
	public String listAjax(HttpServletRequest request, Model model){
		
		Map<String,Object> map = new HashMap<String, Object>();
		String searchKeyword = request.getParameter("searchKeyword");
		String search = request.getParameter("search");
		map.put("searchKeyword", searchKeyword);
		map.put("search", search);
		List<BoardVO> boardlist= boardservice.boardlist(map);
		model.addAttribute("boardlist", boardlist);
		return "listAjax";
	}
	
	
	//����������������������������
	
}
