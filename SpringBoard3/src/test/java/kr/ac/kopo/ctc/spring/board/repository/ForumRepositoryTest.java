package kr.ac.kopo.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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
	
	
	//create 페이지 확인용
	@Test
	void createBoardMember() {
		Forum forum = new Forum();
		String insertTitle = "제목";
		String insertAuthor = "글쓴이";
		String insertContent = "내용임";
		
		for(int i = 0; i < 100; i++) {
			//int a = (int)(Math.random()*100);
			insertTitle += i;
			insertAuthor += i;
			insertContent += i;
			forum.setTitle(insertTitle);
			forum.setAuthor(insertAuthor);
			forum.setContent(insertContent);
			forumRepository.save(forum);
		}
		 
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
