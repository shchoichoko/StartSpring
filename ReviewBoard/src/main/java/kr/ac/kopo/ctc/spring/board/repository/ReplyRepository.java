package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.Reply;
import kr.ac.kopo.ctc.spring.board.domain.ReviewBoard;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	void findById(ReviewBoard reviewBoard);
    @Query("select r from reply r where r.reviewBoard.id = :id")
    List<Reply> findReplyBoardId(@Param("id") Integer id);
}
