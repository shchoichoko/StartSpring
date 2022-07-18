package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;
import java.util.Optional;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

public interface BoardItemService {
	void test();
	void testAopBefore();
	void testAopAfter();
	String testAopAfterReturning();
	void testAopAfterThrowing();
	void testAopAround();
	List<BoardItem> showLists();
	List<BoardItem> showOneView(Integer id);
}
