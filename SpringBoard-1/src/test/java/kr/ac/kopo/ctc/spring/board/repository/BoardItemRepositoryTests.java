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

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;



@SpringBootTest
class BoardItemRepositoryTests {

	@Autowired
	BoardItemRepository boardItemRepository;
	
	//selectOne
	@Test
	void selectOne() {
		Optional<BoardItem> boardItemOpt = boardItemRepository.findOneByAuthor("안재형");
	}
	//selectAll
	@Test
	void findByTitle() {
		List<BoardItem> boardItem = boardItemRepository.findAllByTitle("점심은?");
	}
	//delete
	@Test
	void deleteById() {
		List<BoardItem> boardItem = boardItemRepository.deleteById(1);
	}
	//create
	@Test
	void createContent() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(5);
		boardItem.setAuthor("손흥민");
		boardItem.setContent("대승우 가즈아");
		boardItem.setTitle("득점왕 주현");
		boardItem.setNo(5);
		boardItem.setDate(new Date());
		boardItemRepository.save(boardItem);
	}
	//update
	@Test
	void update() {
		Optional<BoardItem> boardItem = boardItemRepository.findById(2);
		boardItem.ifPresent(selectBoardItem -> {
			selectBoardItem.setAuthor("홍길동");
			selectBoardItem.setDate(new Date());
			selectBoardItem.setNo(4);
			selectBoardItem.setTitle("업데이트제목");
			boardItemRepository.save(selectBoardItem);
		});
	}	
	// search title
	@Test
	void searchTitle() {
		List<BoardItem> boardItem = boardItemRepository.findByTitleContaining("점심");
	}
	
	// page all
	@Test
	void showAllPage() {
		//PageRequest.of(page, size)
		PageRequest pageRequest = PageRequest.of(2, 1);
		Page<BoardItem> boardItem = boardItemRepository.findAll(pageRequest);
	}
	
	//page, search title
	void searchAndPage() {
		//PageRequest.of(page, size)
		PageRequest pageRequest = PageRequest.of(2, 1);
		Page<BoardItem> boardItem = boardItemRepository.findByTitleContaining("점심",pageRequest);
	}
	
}
