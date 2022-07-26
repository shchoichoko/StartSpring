package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.ParentTable;

@Repository
public interface ParentTableRepository extends JpaRepository<ParentTable, Integer>{

}
