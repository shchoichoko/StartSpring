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

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@SpringBootTest
class BoardGroupRepositoryTest {
	@Autowired
	BoardGroupRepository bgr;
	@Autowired
	BoardItemRepository bir;
	
	
	//create
	@Test
	void createBoardMember() {
		BoardGroup bg = new BoardGroup();
		bg.setName("손흥민2");
		bgr.save(bg);
		
		BoardItem bi1 = new BoardItem();
		bi1.setAuthor("홍길동작성");
		bi1.setTitle("도적질");
		bi1.setContent("동에번쩍 서에번쩍");
		bi1.setBoardgroup(bg);
		bir.save(bi1);
		
		BoardItem bi2 = new BoardItem();
		bi2.setAuthor("차두리");
		bi2.setTitle("달리기");
		bi2.setContent("분노의 질주");
		bi2.setBoardgroup(bg);
		bir.save(bi2);
		 
	}
	/*
	@Test
	void checkBoardGroup() {
		BoardItem boardItem = bir.findById(1).get();
	}
		
	
	@Test
	void checkBoardItem() {
		BoardGroup boardgroup = bgr.findById(1).get();
		System.out.print("1");
	}

	@Test
	void deleteTest() {
		bgr.deleteById(1);
	}
	*/
}
