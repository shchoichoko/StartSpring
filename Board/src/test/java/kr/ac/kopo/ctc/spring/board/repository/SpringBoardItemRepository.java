package kr.ac.kopo.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.kopo.ctc.spring.board.domain.SpringBoardItem;


class SpringBoardItemRepository {

	@Autowired
	SpringBoardItemRepositroy springBoardItemRepositroy;

	
	//create
	@Test
	void createContent() {
		SpringBoardItem springBoardItem = new SpringBoardItem();
		springBoardItem.setName("손흥민");
		springBoardItem.setContent("글내용");
		springBoardItem.setTitle("글제목");
		springBoardItem.setDate(new Date());
		springBoardItemRepositroy.save(springBoardItem);
	}
}
