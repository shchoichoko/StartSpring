package kr.ac.kopo.ctc.spring.board.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;

@Mapper
@Repository
public interface BoardReplyMapper {
	BoardReply findOneById(int i);
	List<BoardReply> findAll();
	List<BoardReply> findAllByCondition(BoardReply boardReply, RowBounds rowBounds);
	int insertBoardItem(Long id, String author,String title,String content);
	int updateAuthor(BoardReply boardReply);
	int deleteById(BoardReply boardReply);
	List<BoardReply> searchTitle(BoardReply boardReply);
	
	
}
