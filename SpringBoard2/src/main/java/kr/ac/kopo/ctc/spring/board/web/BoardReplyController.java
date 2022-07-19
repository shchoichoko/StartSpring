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

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.repository.BoardReplyRepository;
import kr.ac.kopo.ctc.spring.board.service.BoardReplyService;
import kr.ac.kopo.ctc.spring.board.service.BoardReplyServiceImpl;
import kr.ac.kopo.ctc.spring.board.service.ForumService;

@Controller
@RequestMapping(value = "/boardItem")
public class BoardReplyController {

	@Autowired
	private BoardReplyService  boardReplyService;
	@Autowired
	private BoardReplyRepository boardReplyRepository;
	@Autowired
	private ForumService forumService;
	
	//글 목록 보기
	@RequestMapping(value = "/showItems")
	public String showLists(Model model) {
		//model.addAttribute("boardItems", boardReplyServiceImpl.showItems());
		return "showItems";
	}

	
}
