package kr.ac.kopo.ctc.spring.board.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.repository.ForumRepository;
import kr.ac.kopo.ctc.spring.board.repository.BoardReplyRepository;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	ForumRepository boardGroupRepository;
	
	@Autowired
	BoardReplyRepository boardItemRepository;
	
	@Override
	public String testNoAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testnoTransactional() {
		BoardReply boardReply = boardItemRepository.findById(3).get();
		//boardReply.setTitle("update1!");
		boardItemRepository.save(boardReply);
		
		throw new RuntimeException("Spring Boot No Transactional Test");
	}

	@Override
	@Transactional
	public String testTransactional() {
		BoardReply boardReply = boardItemRepository.findById(3).get();
		//boardReply.setTitle("update2!!!");
		boardItemRepository.save(boardReply);
		throw new RuntimeException("Spring Boot Transactional Test");
	}

}
