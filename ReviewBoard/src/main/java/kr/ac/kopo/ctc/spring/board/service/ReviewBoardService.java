package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Reply;
import kr.ac.kopo.ctc.spring.board.domain.ReviewBoard;
import kr.ac.kopo.ctc.spring.board.repository.ReplyRepository;
import kr.ac.kopo.ctc.spring.board.repository.ReviewBoardRepository;

@Service
public class ReviewBoardService {
	@Autowired
	ReviewBoardRepository reviewBoardRepository;

	@Autowired
	ReplyRepository replyRepository;
	
	public void write(ReviewBoard reviewBoard) {
		reviewBoardRepository.save(reviewBoard);
	}
	
	public ReviewBoard viewList(Integer id) {
		
		return reviewBoardRepository.findById(id).get();
	}
	
	public List<ReviewBoard> showList() {
		return reviewBoardRepository.findAll();
	}
	public List<Reply> childViewList(Integer id) {

		return replyRepository.findReplyBoardId(id);
	}
}
