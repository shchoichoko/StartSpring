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

import kr.ac.kopo.ctc.spring.board.domain.Forum;
import kr.ac.kopo.ctc.spring.board.domain.BoardReply;

@SpringBootTest
class ForumRepositoryTest {
	@Autowired
	ForumRepository forumRepository;
	@Autowired
	BoardReplyRepository boardReplyRepository;
	
	
	//create
	@Test
	void createBoardMember() {
		Forum forum = new Forum();
		forum.setAuthor("손흥민2");
		forumRepository.save(forum);
		
		BoardReply boardReply = new BoardReply();
		boardReply.setAuthor("홍길동작성");
		boardReply.setTitle("도적질");
		boardReply.setContent("동에번쩍 서에번쩍");
		boardReply.setBoardgroup(forumRepository);
		boardReplyRepository.save(boardReply);
		
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
