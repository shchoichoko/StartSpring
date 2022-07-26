package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.ChildTable;

@Repository
public interface ChildTableRepository extends JpaRepository<ChildTable, Integer> {

}
