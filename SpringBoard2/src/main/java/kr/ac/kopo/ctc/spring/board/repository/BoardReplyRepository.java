package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;

@Repository
public interface BoardReplyRepository extends JpaRepository<BoardReply, Integer>, JpaSpecificationExecutor<BoardReply> {

	
    @Query("select r from boardReply r where r.forum.id = :id")
    List<BoardReply> findReplyBoardId(@Param("id") Integer id);
	
//	List<BoardReply> deleteByReplyId(Integer replyId);
    
    /*
	Optional<BoardReply> findOneByAuthor(String author);
	
	Page<BoardReply> findAllByAuthor(String author, Pageable pageable);
	
	List<BoardReply> findAllByTitle(String title);
	
	List<BoardReply> findByTitleContaining(String title);
	
	Page<BoardReply> findByTitleContaining(String title, Pageable pageable);
	

	
	List<BoardReply> findAllByBoardgroup_id(int id);
	
	*/
}
