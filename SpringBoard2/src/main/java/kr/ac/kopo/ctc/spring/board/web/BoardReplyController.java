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
public class BoardReplyController {

	@Autowired
	private BoardReplyService  boardReplyService;
	@Autowired
	private ForumService forumService;
	
	//글보기에서 댓글 작성하기 눌렀을때 실행
	@RequestMapping(value = "/replyWrite")
	public String replyWrite(@ModelAttribute BoardReply boardReply, Integer id, Model model) {
		boardReplyService.boardReplyWrite(boardReply, id);
		List<BoardReply> boardReplyList = boardReplyService.getReplyBoardID(id);
		model.addAttribute("boardReplyList", boardReplyList);
		model.addAttribute("forum",forumService.forumView(id));
		return "redirect:/forum/showOneForum/" + id;
	}
	/*
	@RequestMapping(value = "replyDelete")
	public String deleteReply(@ModelAttribute BoardReply boardReply) {
		boardReplyService.replyDelete(boardReply);
		return "replyDeleteComplete";
	}
	*/
	// 댓글 삭제하기
	@RequestMapping(value = "/replyDelete/{replyId}/{id}")
	public String deleteOne(@PathVariable("replyId") String getReplyId,@PathVariable("id") String forumId) {
		Integer id = Integer.parseInt(getReplyId);
		Integer intForumId = Integer.parseInt(forumId);
		boardReplyService.boardReplyDelete(id);
		return "redirect:/forum/showOneForum/" + intForumId;
	}

}
