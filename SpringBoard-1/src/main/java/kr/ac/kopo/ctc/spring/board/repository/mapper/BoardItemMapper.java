package kr.ac.kopo.ctc.spring.board.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Mapper
@Repository
public interface BoardItemMapper {
	BoardItem findOneById(Long id);
	List<BoardItem> findAll();
	List<BoardItem> findAllByCondition(BoardItem boarditem, RowBounds rowBounds);
	int insertBoardItem(Long id, String author,String title,String content);
	int updateAuthor(BoardItem boarditem);
	int deleteById(BoardItem boarditem);
	List<BoardItem> searchTitle(BoardItem boarditem);
	
	
}
