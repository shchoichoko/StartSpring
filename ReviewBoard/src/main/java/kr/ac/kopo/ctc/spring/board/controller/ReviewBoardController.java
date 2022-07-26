package kr.ac.kopo.ctc.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.domain.Reply;
import kr.ac.kopo.ctc.spring.board.domain.ReviewBoard;
import kr.ac.kopo.ctc.spring.board.repository.ReviewBoardRepository;
import kr.ac.kopo.ctc.spring.board.service.ReviewBoardService;

@Controller
@RequestMapping(value = "/board")
public class ReviewBoardController {
	@Autowired
	ReviewBoardService reviewBoardService;

	
	//목록 조회
	@RequestMapping(value="/viewAll")
	public String viewAllBoard(Model model) {
		//System.out.println("전장조아~"+reviewBoardService.showList().size());
		model.addAttribute("reviewBoardItems",reviewBoardService.showList());
		return "viewAll";
	}
	
	@RequestMapping(value="/viewChild")
	public String viewChildBoard(Model model) {
		Integer id = 3;
		ReviewBoard reviewBoard = new ReviewBoard();
		reviewBoard.setId(id);
		List<Reply> reply = reviewBoardService.childViewList(3);
		model.addAttribute("replyItems",reply);
		return "childView";
	}
	
}
