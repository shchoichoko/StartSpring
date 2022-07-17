package kr.ac.kopo.ctc.spring.board.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardGroupRepository;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	BoardGroupRepository boardGroupRepository;
	
	@Autowired
	BoardItemRepository boardItemRepository;
	
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
		BoardItem boardItem = boardItemRepository.findById(3).get();
		boardItem.setTitle("update1!");
		boardItemRepository.save(boardItem);
		
		throw new RuntimeException("Spring Boot No Transactional Test");
	}

	@Override
	@Transactional
	public String testTransactional() {
		BoardItem boardItem = boardItemRepository.findById(3).get();
		boardItem.setTitle("update2!!!");
		boardItemRepository.save(boardItem);
		throw new RuntimeException("Spring Boot Transactional Test");
	}

}
