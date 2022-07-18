package kr.ac.kopo.ctc.spring.board.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonBackReference;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardGroupRepository;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

/*
@RestController
@RequestMapping(value="/rest")
public class BoardItemRestController {
		
	@Autowired
	BoardGroupRepository boardGroupRepository;
	@Autowired
	BoardItemRepository boardItemRepository;

	@RequestMapping(value="/boardItem1")
	public ResponseEntity<BoardItem> boardItem1() {
		BoardItem boardItem = boardItemRepository.findById(1).get();		
		return ResponseEntity.ok(boardItem);

	}	
	
	@RequestMapping(value="/boardItems1")
	public ResponseEntity<List<BoardItem>> boardItems1() {
		List<BoardItem> boardItem = boardItemRepository.findAllByBoardgroup_id(2);
		return	ResponseEntity.ok(boardItem);
	}
	
	@RequestMapping(value="/boardItem2")
	public BoardItem boardItem2() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(1);
		boardItem.setAuthor("updated4");
		return boardItem;
	}

	@RequestMapping(value="/boardItems2")
	public List<BoardItem> boardItems2() {
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setId(1);
		boardItem1.setAuthor("updated1");
		
		BoardItem boardItem2 = new BoardItem();		
		boardItem2.setId(2);
		boardItem2.setAuthor("updated3");
		
		List<BoardItem> boardItems = new ArrayList<BoardItem>();
		boardItems.add(boardItem1);
		boardItems.add(boardItem2);
		return	boardItems;
	}
	
	

	
}	
*/