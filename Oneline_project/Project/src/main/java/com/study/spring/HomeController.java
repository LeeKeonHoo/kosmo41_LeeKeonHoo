package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
	@Resource(name = "BoardService")
	private BoardService boardService;
	
	//로그인 페이지
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	//로그인 체크 및 리스트 호출
	@RequestMapping("/loginChk")
	public String loginChk(Model model,
							@RequestParam Map<String, Object> map,
							HttpSession session) {
		
	
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map2 = boardService.loginChk(map);
		
		String id = map.get("id").toString();
		String pw = map.get("pw").toString();
		
		if(map2 == null) {
			model.addAttribute("check", "idfail");
			return "/login";
		}else if(map2.get("password").toString().equals(pw)) {
//			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//			list = boardService.list(map2);	

			session.setAttribute("login", map2);
//			model.addAttribute("list", list);
			
			return "redirect:list";			
		}else {
			model.addAttribute("check", "pwfail");
			return "/login";
		}
	}
	
	//리스트 호출
	@RequestMapping("/list")
	public String list(Model model, @RequestParam Map<String, Object> map
						,HttpSession session) {				
		
		Map <String, Object> sessionMap = (Map)session.getAttribute("login");

		if(sessionMap != null){
			String sessionName = (String) sessionMap.get("name");
			String sessionAdmin = (String) sessionMap.get("admin");
			map.put("sessionName", sessionName);
			map.put("sessionAdmin", sessionAdmin);

		Map <String, Object> searchmap = new HashMap<String, Object>();
		searchmap.put("search",map.get("search"));
		searchmap.put("startdate",map.get("startdate"));
		searchmap.put("enddate",map.get("enddate"));
		
		model.addAttribute("searchmap",searchmap);
			
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = boardService.kwanhan(sessionName);
		model.addAttribute("kwanhan", list);

		for (Map<String, Object> map2 : list) {
			for (Map.Entry<String, Object> entry : map2.entrySet()) {
				String key = entry.getKey();
		 	    Object value = entry.getValue();
		 	     map.put(key,value);
			}
		}
		session.setAttribute("admin", map.get("ADMIN"));
		session.setAttribute("adminname", map.get("ADMINNAME"));
		
		list = boardService.list(map);	
		model.addAttribute("list", list);
		
		
		}
		return "/list";
		
	}

	//상태 Ajax
	@RequestMapping("/status")
	public String status(Model model,@RequestParam Map<String, Object> map) {
	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		list = boardService.searchAjax(map);
		model.addAttribute("list", list);
			
		return "/statusAjax";
	}
	
	//글작성 페이지
	@RequestMapping("/write")
	public String write(Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = boardService.writeview();
		
		model.addAttribute("login", map);
				
		return "/write";
	}
	
	//작성글 보기
	@RequestMapping("/content_view")
	public String content_view(@RequestParam int seq,Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = boardService.content(seq);
		model.addAttribute("content", map);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = boardService.historyContent(seq);
		model.addAttribute("history", list);
		
		
		return "/write";
	}
	
	//글작성 하기
	@RequestMapping("/writeOk")
	public String writeOk(@RequestParam Map<String, Object> map) {

		
		System.out.println("map.get(\"event\") : " + map.get("event"));
		
		int insert = boardService.insertBoard(map);
		
		int history = boardService.history(map);
		
		return "redirect:list";
	}
	
	
	//결제 하기
	@RequestMapping("/update")
	public String update(@RequestParam Map<String, Object> map) {
		

//	    //MAP의 KEY값을 이용하여 VALUE값 가져오기
//	    for (String mapkey : map.keySet()){
//	        System.out.println("key : "+mapkey+", value : "+map.get(mapkey));
//	    }
		
		int update = boardService.updateBoard(map);

		int history = boardService.history(map);
		
		return "redirect:list";
	}
	
	//결제 하기
	@RequestMapping("/lmsiupdate")
	public String lmsiupdate(@RequestParam Map<String, Object> map) {
		
		int update = boardService.lmsiupdateBoard(map);

		int history = boardService.history(map);
		
		return "redirect:list";
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("login");
		session.invalidate();
		return "/login";
	}
	
	//대리 결제
	@RequestMapping("/popup")
	public String popup(Model model, @RequestParam String kwanhan) {
		
		if(kwanhan.equals("과장")) {
			kwanhan = "3";
		}
		if(kwanhan.equals("부장")) {
			kwanhan = "4";
		}
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = boardService.popuplist(kwanhan);	
		model.addAttribute("popup", list);

		return "/popup";
	}

	//대리 결제 Ajax
	@RequestMapping("/popupajax")
	public String popupajax(Model model,@RequestParam Map<String, Object> map) {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2 = boardService.popupajax(map);	
		model.addAttribute("popupajax", map2);
		
		return "/popupajax";
	}
	
	//대리 결제 승인
	@RequestMapping("/popupok")
	public String popupok(Model model,@RequestParam Map<String, Object> map) {
		int popupok = boardService.popupok(map);	
		
		return "/popup";
	}
	
	//회원가입
	@RequestMapping("/join")
	public String join() {
		
		return "/join";
	}
	
	//메일보내기
	@RequestMapping("/mailSend")
	public void mailSend(HttpServletRequest request) {
//		request.setCharacterEncoding("utf-8");
		  
		String company  = request.getParameter("company");
		String name = request.getParameter("name");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		  
		Properties p = new Properties(); // 정보를 담을 객체
		  
		p.put("mail.smtp.host","smtp.naver.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		 
		  
		try{
//		    Authenticator auth = new SMTPAuthenticatior();
		    Session ses = Session.getInstance(p, 
		    		new javax.mail.Authenticator() {
		    			protected PasswordAuthentication getPasswordAuthentication() {
		    				return new PasswordAuthentication("kunhoohei@naver.com","samjin201217001!");
		    			}
		    });
		      
		    ses.setDebug(true);
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체 
		 
		    msg.setSubject(subject); //  제목
		 
		    StringBuffer buffer = new StringBuffer();
		    buffer.append("업체명 : ");
		    buffer.append(company+"<br>");
		    buffer.append("담당자 : ");
		    buffer.append(name+"<br>");   
		    buffer.append("연락처 : ");
		    buffer.append(number+"<br>");
		    buffer.append("이메일 : ");
		    buffer.append(email+"<br>");   
		    buffer.append("제목 : ");
		    buffer.append(subject+"<br>");
		    buffer.append("내용 : ");
		    buffer.append(content+"<br>");
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); 
		 
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		     
		    msg.setContent(buffer.toString(), "text/html;charset=UTF-8"); // 내용
		    Transport.send(msg); // 전송  
		 
		} catch(Exception e){
		    e.printStackTrace();
		    return;
		}
//		return "/join";
	}

}
