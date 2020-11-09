package com.mybatis.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.mybatis.board.vo.BoardVO;
import com.mybatis.board.vo.memberVO;
import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final String MODULE_NAME="board";
	private final String MMODULE_NAME="member";
	@Autowired
	private boardService service;
	
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) {
		System.out.println("BoardController.list.pageObject"+pageObject);
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		return MODULE_NAME+"/list";
	}
	@GetMapping("/write.do")
	public String writeForm() {
		System.out.println("BoardController.writeForm()");
		return MODULE_NAME+"/write";
	}
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		System.out.println("BoardController.write()");
		service.write(vo);
		return "redirect:list.do";
	}
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		model.addAttribute("vo", service.view(no,0));
		
		return MODULE_NAME+"/update";
	}
	@PostMapping("/update.do")
	public String update(BoardVO vo) {
		service.update(vo);
		return "redirect:view.do?no="+vo.getNo()+"&inc=0";
	}
	@GetMapping("/view.do")
	public String view(Model model, int no,int inc ) {
		System.out.println("BoardController.view.do?no="+no);
		model.addAttribute("vo", service.view(no, inc));
		return MODULE_NAME+"/view";
	}
	@GetMapping("/delete.do")
	public String delete(int no) {
		System.out.println("BoardControll.delete()"+no);
		service.delete(no);
		return "redirect:list.do";
	}
	@GetMapping("/join.do")
	public String joinForm(Model model,HttpServletRequest request) {
		String inputid=request.getParameter("inputid");
		String idck=request.getParameter("idck");
		System.out.println("BoardController.joinForm");
		model.addAttribute("inputid",inputid);
		model.addAttribute("idck", idck);
		return MMODULE_NAME+"/join";	
	}
	@PostMapping("/join.do")
	public String join(memberVO vo) {
		System.out.println("BoardController.join");
		service.join(vo);
		return "redirect:list.do";
	}
	@GetMapping("/sameid.do")
	public String sameidFrom(Model model,HttpServletRequest request) {
		String inputid=request.getParameter("inputid");
		String result=request.getParameter("result");
		System.out.println("BoardController.sameidForm"+inputid);
		model.addAttribute("inputid",inputid);
		model.addAttribute("result", result);
		return MMODULE_NAME+"/sameid";
	}
	
	@GetMapping("/sameidck.do")
	public String sameid(HttpServletRequest request, Model model) {
		String inputid=request.getParameter("id");
		System.out.println("BoardController.sameidck"+inputid);
		model.addAttribute("inputid", inputid);
		model.addAttribute("result", service.sameid(inputid));
		System.out.println(service.sameid(inputid));
		return "redirect:sameid.do";
		
	}
	
	@GetMapping("/login.do")
	public String loginForm(Model model,HttpServletRequest request) {
		String nook=request.getParameter("nook");
		model.addAttribute("nook", nook);
		System.out.println(nook);
		return MMODULE_NAME+"/login";
	}
	
	@PostMapping("/login.do")
	public String login(HttpSession session,@RequestParam ("id")String id,@RequestParam("pw")String pw, Model model) {
		String Url="";
		String nook="nook";
		if(session.getAttribute("login")!=null) {
			session.removeAttribute("login");
		}
		memberVO mDTO=service.login(id);
		if(mDTO!=null&&mDTO.getPw().equals(pw)) {
			session.setAttribute("login", mDTO.getName());
			Url="redirect:list.do";
		}else if(mDTO==null||!mDTO.getPw().equals(pw)) {
			model.addAttribute("nook", nook);
			Url="redirect:login.do";
		}
		return Url;
	}
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:list.do";
		
	}
}
