package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.ParentTable;
import kr.ac.kopo.ctc.spring.board.repository.ParentTableRepository;


@Service 
public class ParentTableService {
	
	@Autowired
	ParentTableRepository parentTableRepository;
	
	public List<ParentTable>viewAll() {
		return parentTableRepository.findAll();
	}
	
	public ParentTable viewOne(Integer id) {
		
		return parentTableRepository.findById(id).get();
	}
}
