package kr.ac.kopo.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;



@SpringBootTest
class BoardReplyRepositoryTests {

	@Autowired
	BoardReplyRepository boardReplyRepository;
	
	//selectOne
	@Test
	void selectOne() {
		Optional<BoardReply> boardReplyOpt = boardReplyRepository.findOneByAuthor("안재형");
	}
	//selectAll
	@Test
	void findByTitle() {
		List<BoardReply> boardReply = boardReplyRepository.findAllByTitle("점심은?");
	}
	//delete
	@Test
	void deleteById() {
		List<BoardReply> boardReply = boardReplyRepository.deleteById(1);
	}
	//create
	@Test
	void createContent() {
		BoardReply boardReply = new BoardReply();
		boardReply.setId(5);
		boardReply.setAuthor("손흥민");
		boardReply.setContent("대승우 가즈아");
		boardReply.setTitle("득점왕 주현");
		//boardReply.setDate(new Date());
		boardReplyRepository.save(boardReply);
	}
	//update
	@Test
	void update() {
		Optional<BoardReply> boardReply = boardReplyRepository.findById(2);
		boardReply.ifPresent(selectBoardReply -> {
			selectBoardReply.setAuthor("홍길동");
			//selectBoardReply.setDate(new Date());
			selectBoardReply.setTitle("업데이트제목");
			boardReplyRepository.save(selectBoardReply);
		});
	}	
	// search title
	@Test
	void searchTitle() {
		List<BoardReply> boardReply = boardReplyRepository.findByTitleContaining("점심");
	}
	
	// page all
	@Test
	void showAllPage() {
		//PageRequest.of(page, size)
		PageRequest pageRequest = PageRequest.of(2, 1);
		Page<BoardReply> boardReply = boardReplyRepository.findAll(pageRequest);
	}
	
	//page, search title
	void searchAndPage() {
		//PageRequest.of(page, size)
		PageRequest pageRequest = PageRequest.of(2, 1);
		Page<BoardReply> boardReply = boardReplyRepository.findByTitleContaining("점심",pageRequest);
	}
	
}
