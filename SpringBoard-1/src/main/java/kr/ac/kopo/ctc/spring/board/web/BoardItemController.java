package kr.ac.kopo.ctc.spring.board.web;

import java.util.List;
import java.util.Map;
import java.util.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;
import kr.ac.kopo.ctc.spring.board.service.BoardItemService;
import kr.ac.kopo.ctc.spring.board.service.BoardItemServiceImpl;

@Controller
@RequestMapping(value = "/boardItem")
public class BoardItemController {

	@Autowired
	private BoardItemServiceImpl boardItemServiceImpl;
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	//글 목록 보기
	@RequestMapping(value = "/showList")
	public String showLists(Model model) {
		model.addAttribute("boardItems", boardItemServiceImpl.showLists());
		return "list";
	}
	
	//글 하나 보기
	@RequestMapping(value = "/oneView")
	public String goOneView(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		BoardItem boardItem = boardItemServiceImpl.showOneView(Integer.parseInt(id));
		model.addAttribute("boardItem",boardItem);
		return "oneView";
	}
	
	//글작성 하러 가기
	@RequestMapping(value = "/write")
	public String goWrite(Model model) {
				
		model.addAttribute("namename","홍길동");
		//model.addAttribute("boardItems",boardItemServiceImpl.showOneView(Integer.parseInt(id)));
		return "write";
	}
	
	//글 작성 확정하기
	@RequestMapping(value = "/confirmWrite")
	public String confirmWrite(Model model, HttpServletRequest request) {
		
		model.addAttribute("namename","홍길동");
		//model.addAttribute("boardItems",boardItemServiceImpl.showOneView(Integer.parseInt(id)));
		return "write";
	}

	/*
	 * @RequestMapping(value = "/list") public List<BoardItem> list(Model model) {
	 * return boardItemRepository.findAll(); }
	 */

	@RequestMapping(value = "")
	public String boaidItem(Model model) {
		model.addAttribute("name", "초코");
		return "hello";
	}

	@RequestMapping(value = "/getParameter")
	public String getParameter(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping(value = "/requestParam")
	public String requestParam(Model model, @RequestParam(value = "name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping(value = "/pathVariable/{name}")
	public String pathVariable(Model model, @PathVariable("name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping(value = "/modelAttribute")
	public String modelAttribute(Model model, @ModelAttribute BoardItem boardItem) {
		model.addAttribute("name", boardItem.getName());
		return "hello";
	}

	@RequestMapping(value = "/requestBody1")
	public String requestBody1(Model model, @RequestBody Map<String, Object> obj) {
		model.addAttribute("name", obj.get("name"));
		return "hello";
	}

	@RequestMapping(value = "/requestBody2")
	public String requestBody2(Model model, @RequestBody BoardItem boardItem) {
		model.addAttribute("name", boardItem.getName());
		return "hello";
	}
}
