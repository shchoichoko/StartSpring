package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.SpringBoardItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface SpringBoardItemRepositroy extends JpaRepository<SpringBoardItem, Integer>, JpaSpecificationExecutor<SpringBoardItem>{
	
}
