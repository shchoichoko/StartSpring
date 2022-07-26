package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.ChildTable;
import kr.ac.kopo.ctc.spring.board.domain.ParentTable;
import kr.ac.kopo.ctc.spring.board.repository.ChildTableRepository;
import kr.ac.kopo.ctc.spring.board.repository.ParentTableRepository;

@Service
public class ChildTableService {
	@Autowired
	ParentTableRepository parentTableRepository;
	@Autowired
	ChildTableRepository childTableRepository;
	
	public List<ChildTable> viewChild(Integer id) {
		return parentTableRepository.findById(id).get().getChildTable();
		//findById 는 Optional 타입이라 .get().getChildTable()로 리스트 형태로 자식을 가져옴
	}
	
}
