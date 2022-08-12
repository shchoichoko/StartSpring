package kr.ac.kopo.ctc.spring.board.repository.mapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@SpringBootTest
public class BoardReplyMapperTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardReplyMapperTest.class);

	@Autowired
	BoardReplyMapper boardItemMapper;

	// selectOne
	@Test
	void selectOne() {
		BoardItem boardItems = boardItemMapper.findOneById(1);
	}
	@Test
	public void findAll() {
		List<BoardItem> boardItems = boardItemMapper.findAll();
		for (BoardItem boardItem : boardItems) {
			System.out.println(boardItem.getAuthor());
		}
	}
	@Test
	public void findAllByCondition() {
		BoardItem boardItems = new BoardItem();
		boardItems.setAuthor("최수혁");

		RowBounds rowBounds = new RowBounds(0, 10);

		List<BoardItem> boardItems2 = boardItemMapper.findAllByCondition(boardItems, rowBounds);
		for (BoardItem boardItem : boardItems2) {
			System.out.println(boardItem.getAuthor());
		}
	}
	/*
	// create
	@Test
	void insertBoardItem() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(7);
		boardItem.setAuthor("손흥민");
		boardItem.setTitle("득점왕 주현");
		boardItem.setContent("오늘은 국밥");
		boardItemMapper.insertBoardItem(boardItem.getId(), boardItem.getAuthor(), boardItem.getTitle(),
		boardItem.getContent());
	}
	// update
	@Test
	void update() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(1);
		boardItem.setAuthor("홍길동");
		boardItem.setTitle("업데이트제목");
		boardItemMapper.updateAuthor(boardItem);
	}
	*/
	
	@Test
	void searchTitle() {
		BoardItem boardItem = new BoardItem();
		boardItem.setTitle("점심");
		List<BoardItem> boardItems = boardItemMapper.searchTitle(boardItem);
	}
	/*
	// delete One
	@Test
	void deleteOne() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(2);
		boardItemMapper.deleteById(boardItem);
	}
	*/
}
