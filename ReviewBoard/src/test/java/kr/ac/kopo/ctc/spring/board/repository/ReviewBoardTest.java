package kr.ac.kopo.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import kr.ac.kopo.ctc.spring.board.domain.Reply;
import kr.ac.kopo.ctc.spring.board.domain.ReviewBoard;
@SpringBootTest
class ReviewBoardTest {
	
	@Autowired
	ReviewBoardRepository reviewBoardRepository;
	@Autowired
	ReplyRepository replyRepository;
	
	@Test
	void createBoardMember() { 
		ReviewBoard reviewBoard = new ReviewBoard();
		reviewBoard.setAuthor("손흥민");
		reviewBoardRepository.save(reviewBoard);
		
		Reply reply = new Reply();
		reply.setAuthor("손흥민");
		reply.setTitle("슛돌이");
		reply.setContent("동에번쩍 서에번쩍");
		reply.setReviewBoard(reviewBoard);
		replyRepository.save(reply);
		
		Reply reply2 = new Reply();
		reply2.setAuthor("손흥민");
		reply2.setTitle("달리기");
		reply2.setContent("분노의 질주");
		reply2.setReviewBoard(reviewBoard);
		replyRepository.save(reply2);

	}

}
