package kr.ac.kopo.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
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
	BoardGroupRepository boardGroupRepository;
	@Autowired
	BoardItemRepository boardItemRepository;
	Date nowTime=new Date(); 
	SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-dd");
	
	//create
	@Test
	void createBoardMember() {

		BoardGroup boardGroup = new BoardGroup();
		boardGroup.setName("손흥민");
		boardGroupRepository.save(boardGroup);
		
		BoardItem boardItem = new BoardItem();
		boardItem.setName("손흥민");
		boardItem.setTitle("슛돌이");
		boardItem.setContent("동에번쩍 서에번쩍");
		boardItem.setDate(nowTime);
		boardItem.setBoardgroup(boardGroup);
		boardItem.setViewCnt(0);
		boardItem.setNo(1);
		boardItemRepository.save(boardItem);
		
		BoardItem boardItem2 = new BoardItem();
		boardItem2.setName("손흥민");
		boardItem2.setTitle("달리기");
		boardItem2.setContent("분노의 질주");
		boardItem2.setDate(nowTime);
		boardItem2.setBoardgroup(boardGroup);
		boardItem2.setViewCnt(0);
		boardItem2.setNo(2);
		boardItemRepository.save(boardItem2);

		BoardGroup boardGroup2 = new BoardGroup();
		boardGroup2.setName("차두리");
		boardGroupRepository.save(boardGroup2);
		
		BoardItem boardItem3 = new BoardItem();
		boardItem3.setName("차두리");
		boardItem3.setTitle("슛돌이");
		boardItem3.setContent("몸통박치기");
		boardItem3.setDate(nowTime);
		boardItem3.setBoardgroup(boardGroup2);
		boardItem3.setNo(3);
		boardItem3.setViewCnt(0);
		boardItemRepository.save(boardItem3);
		
		BoardItem boardItem4 = new BoardItem();
		boardItem4.setName("차두리");
		boardItem4.setTitle("달리기");
		boardItem4.setContent("분노의 질주");
		boardItem4.setDate(nowTime);
		boardItem4.setBoardgroup(boardGroup2);
		boardItem4.setViewCnt(0);
		boardItem4.setNo(4);
		boardItemRepository.save(boardItem4);
		 
	}
/*
	@Test
	void checkBoardGroup() {
		BoardItem boardItem = boardItemRepository.findById(1).get();
	}
		
	
	@Test
	void checkBoardItem() {
		BoardGroup boardgroup = boardGroupRepository.findById(1).get();
		System.out.print("1");
	}

	@Test
	void deleteTest() {
		bgr.deleteById(1);
	}
	*/
}
