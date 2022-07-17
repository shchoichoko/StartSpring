package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem> {
	
	Optional<BoardItem> findOneByAuthor(String author);
	
	Page<BoardItem> findAllByAuthor(String author, Pageable pageable);
	
	List<BoardItem> findAllByTitle(String title);
	
	List<BoardItem> findByTitleContaining(String title);
	
	Page<BoardItem> findByTitleContaining(String title, Pageable pageable);
	
	List<BoardItem> deleteById(int id);
	
	List<BoardItem> findAllByBoardgroup_id(int id);
}
